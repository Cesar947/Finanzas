package com.finanzas.administrador_recibos.service.implementation;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.administrador_recibos.dao.DetalleFactoringRepository;
import com.finanzas.administrador_recibos.dao.FactoringRepository;
import com.finanzas.administrador_recibos.dao.ResultadoFactoringRepository;
import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.model.Factoring;
import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.model.ResultadoFactoring;
import com.finanzas.administrador_recibos.model.ResultadoModelo;
import com.finanzas.administrador_recibos.service.ResultadoFactoringService;

@Service
public class ResultadoFactoringServiceImpl implements ResultadoFactoringService {

	private ResultadoFactoringRepository resFactRepo;
	
	private FactoringRepository factRepo;
	
	private DetalleFactoringRepository detalleFactoringRepository;
	
	@Autowired
	ResultadoFactoringServiceImpl(ResultadoFactoringRepository resFactRepo, FactoringRepository factRepo){
		this.resFactRepo = resFactRepo;
		this.factRepo = factRepo;
	}

	
	public int restaDeFechas(Date a, Date b) {
    	int resultado = (int) (b.getTime() - a.getTime())/86400000;
    	return resultado;
    }
    
    public BigDecimal HallarTasaDescuento(BigDecimal TEA, int periodoEnDias, BigDecimal valorNominal ) {
    	
    	
	
        double TEP = (Math.pow(1 + TEA.doubleValue(),(periodoEnDias/360)) - 1)*100;
		double d = ((TEP/100)/(1 + TEP/ 100))*100;
		return BigDecimal.valueOf(d);
    }
    
    public BigDecimal HallarValorDescuento(BigDecimal d, BigDecimal valorNominal) {
    	double pDescuento = d.doubleValue()/100;
    	double descuento = pDescuento*valorNominal.doubleValue();
    	return BigDecimal.valueOf(descuento);
    }

    public BigDecimal HallarValorNeto(BigDecimal descuento, BigDecimal valorNominal) {
    	BigDecimal valorNeto = valorNominal.subtract(descuento);
    	return valorNeto;
    }
    
    
    public BigDecimal HallaElValorRecibido (BigDecimal descuento, BigDecimal valorNominal, BigDecimal ValorNeto, BigDecimal pSegDesg, BigDecimal porte, BigDecimal itf)
    {
    	double van = ValorNeto.doubleValue();
    	
    	
    	double port = porte.doubleValue();
    	double it = itf.doubleValue();
    	double sgDg = (pSegDesg.doubleValue()/100)*valorNominal.doubleValue();
    	double valorReci = van - sgDg - port - it;
    	return BigDecimal.valueOf(valorReci);
    }
    
    
    public BigDecimal HallarLaTcea (BigDecimal valorRecibido, BigDecimal valorEntregado,int periodoEnDias)
    {
		
		double TCEA = Math.pow((valorEntregado.doubleValue()/valorRecibido.doubleValue()), (360/periodoEnDias))-1;
    	return BigDecimal.valueOf(TCEA*100);
    }
    
    public BigDecimal HallarTCEATotalDeCartera(List<DetalleFactoring> detalles, BigDecimal valorRecibidoTotal) {
    
    	
    	BigDecimal TCEA = new BigDecimal(0.0);
    	int F = 1;
    	double I  = valorRecibidoTotal.doubleValue();
    	double a = 0;
    	double b = 0.8;
    	double val;
    	double c = 0;
    	double denom = 0;
    	double tirP = 0;
    	double tirA = 0;
    	for(int i = 0; i < 1000; i++) {
    		val = 0;
    		c = (a + b)/2;
    		for(int j = 0; j < detalles.size(); j++) {
    			denom = Math.pow((1 + c),detalles.get(j).getNumeroPeriodoDias());
    			val += detalles.get(j).getMontoValorEntregado().doubleValue()/denom;
    		}
    		
    		if(val < I) {
    			b = c;
    		}
    		else {
    			a = c;
    		}
    		
    		if(Math.abs(val - I) < 0.001){
    			tirP = c;
    			tirA = tirP*360/F;
    			TCEA = new BigDecimal((Math.pow(1 + tirA*(F/360), 360/F) - 1)*100);
    			i = 1000;
    		}
    		
    	}
    	
    	return TCEA;
    	
    }
    
    
    @Override
	public ResultadoFactoring CalcularResultado(List<ReciboHonorarios> recibos, Integer factId) {
    	
    	
    	 Factoring factoring = factRepo.findById(factId).get();
   
    	 ResultadoFactoring rf = new ResultadoFactoring();
    	 
    	 rf.setFactoring(factoring);
    	 
    	 
		 List<DetalleFactoring> listaDetalles = new ArrayList<DetalleFactoring>();
    	
	     Date fechaDscto = factoring.getFechaDescuento();
	     Date fechaVcto;
	     BigDecimal pDscto;
	     BigDecimal dscto;
	     BigDecimal valorNeto;
	     BigDecimal valorRecibido;
	     double valorRecibidoTotal = 0.00;
	     int periodoEnDias;
	     BigDecimal TEA = factoring.getPorcentajeTasaFactoring();
	     BigDecimal pSegDesg = factoring.getPorcentajeDesgravamen();
	     
	     
	     for(int i = 0; i < recibos.size(); i++) {
	    	 DetalleFactoring nuevoDetalle = new DetalleFactoring();
	    	 fechaVcto = recibos.get(i).getFechaVencimiento();
	    	 nuevoDetalle.setReciboHonorarios(recibos.get(i));
	    	 periodoEnDias = restaDeFechas(fechaDscto, fechaVcto);
	    	 nuevoDetalle.setNumeroPeriodoDias(periodoEnDias);
	    	 BigDecimal valorNominal = recibos.get(i).getMontoNeto();
	    	
	    	 
	    	
	    	pDscto = HallarTasaDescuento(TEA, periodoEnDias ,valorNominal);
	    	nuevoDetalle.setPorcentajeTasaDescontada(pDscto); 	
	    	
	    	dscto = HallarValorDescuento(pDscto,valorNominal);
	    	nuevoDetalle.setMontoDescontado(dscto);
	    
	    	valorNeto = HallarValorNeto(dscto, valorNominal);
	    	nuevoDetalle.setMontoValorNeto(valorNeto);
	    	
	    	 valorRecibido = HallaElValorRecibido (dscto, valorNominal, valorNeto, pSegDesg, factoring.getMontoPortes(), factoring.getMontoITF());
	    	 nuevoDetalle.setMontoValorRecibido(valorRecibido); 
	    	 
	    	 valorRecibidoTotal += nuevoDetalle.getMontoValorRecibido().doubleValue();
	    
	    	 nuevoDetalle.setMontoValorEntregado(valorNominal);
	    	  
	    	 
	    	 nuevoDetalle.setTcea(HallarLaTcea(valorRecibido, valorNominal, periodoEnDias));
	    	 
	    	 listaDetalles.add(nuevoDetalle);
	    	 nuevoDetalle = null;
	    	 
	     }
	     BigDecimal vt = new BigDecimal(valorRecibidoTotal);
	     
	     rf.setMontoTotalRecibido(vt);
	     
	     BigDecimal tceaTotal = HallarTCEATotalDeCartera(listaDetalles, rf.getMontoTotalRecibido());
	     rf.setTceaTotal(tceaTotal);
	     
	     
	     
	     for(int i = 0; i < recibos.size(); i++) {
	    	 listaDetalles.get(i).setResultadoFactoring(rf);
	    	 //detalleFactoringRepository.save(listaDetalles.get(i));
	     }
	     
	     
	     
	    return resFactRepo.save(rf);
	     
	 
	        
		
	}
	
    @Override
    public ResultadoModelo mostrarCalculos(Integer factId) {
    	
        ResultadoModelo res = new ResultadoModelo();
        
        List<DetalleFactoring> detalles = detalleFactoringRepository.listarPorFactoring(factId);
        ResultadoFactoring resultado = resFactRepo.listarPorFactoring(factId);
        res.setDetalles(detalles);
        res.setResultado(resultado);
        
        return res;
    	
    	
    }

	
	
}
