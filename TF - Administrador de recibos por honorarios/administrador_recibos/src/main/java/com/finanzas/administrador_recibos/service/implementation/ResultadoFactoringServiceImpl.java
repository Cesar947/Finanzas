package com.finanzas.administrador_recibos.service.implementation;


import java.util.Date;
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
	ResultadoFactoringServiceImpl(ResultadoFactoringRepository resFactRepo, FactoringRepository factRepo, DetalleFactoringRepository detalleFactoringRepository){
		this.resFactRepo = resFactRepo;
		this.factRepo = factRepo;
	    this.detalleFactoringRepository = detalleFactoringRepository;
	}

	
	public int restaDeFechas(Date a, Date b) {
	    long res1 = b.getTime();
	    long res2 = a.getTime();
    	long resultado =  (res1 - res2)/86400000;
    	return (int) resultado;
    }
    
    public double HallarTasaDescuento(double TEA, int periodoEnDias, double valorNominal ) {
    	
    	double res1 = 1 + TEA/100;
    	double res2 = (double)(periodoEnDias);
    	double resP = res2/ (double) 360;
	
        double TEP = (Math.pow(res1,resP));
        TEP = (TEP - 1)*100;
		double d = ((TEP/100)/(1 + TEP/ 100))*100;
		return d;
    }
    
    public double HallarValorDescuento(double d, double valorNominal) {
    	double pDescuento = d/100;
    	double descuento = pDescuento*valorNominal;
    	return descuento;
    }

    public double HallarValorNeto(double descuento, double valorNominal) {
    	double valorNeto = valorNominal - descuento;
    	return valorNeto;
    }
    
    
    public double HallaElValorRecibido (double descuento, double valorNominal, double ValorNeto, double pSegDesg, double porte, double itf)
    {
    	double van = ValorNeto;
    	
    	
    	double port = porte;
    	double it = itf;
    	double sgDg = (pSegDesg/100)*valorNominal;
    	double valorReci = van - sgDg - port - it;
    	return valorReci;
    }
    
    
    public double HallarLaTcea(double valorRecibido, double valorEntregado,int periodoEnDias)
    {
		
		double TCEA = Math.pow((valorEntregado/valorRecibido), (360/periodoEnDias))-1;
    	return TCEA*100;
    }
    
    public double HallarTCEATotalDeCartera(List<DetalleFactoring> detalles, double valorRecibidoTotal) {
    
    	
    	double TCEA = 0.00;
    	int F = 1;
    	double I  = valorRecibidoTotal;
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
    			denom = Math.pow((1 + c), (double) detalles.get(j).getNumeroPeriodoDias());
    			val += detalles.get(j).getMontoValorEntregado()/denom;
    		}
    		
    		if(val < I) {
    			b = c;
    		}
    		else {
    			a = c;
    		}
    		
    		if(Math.abs(val - I) < 0.001){
    			tirP = c;
    			tirA = tirP*(double)360/F;
    			TCEA = (Math.pow(1 + tirA*(F/(double)360), (double)360/F) - 1)*100;
    			i = 1000;
    			return TCEA;
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
	     double pDscto = 0.00;
	     double dscto = 0.00;
	     double valorNeto = 0.00;
	     double valorRecibido = 0.00;
	     double valorRecibidoTotal = 0.00;
	     int periodoEnDias;
	     double TEA = factoring.getPorcentajeTasaFactoring();
	     double pSegDesg = factoring.getPorcentajeDesgravamen();
	     
	     
	     for(int i = 0; i < recibos.size(); i++) {
	    	 DetalleFactoring nuevoDetalle = new DetalleFactoring();
	    	 fechaVcto = recibos.get(i).getFechaVencimiento();
	    	 nuevoDetalle.setReciboHonorarios(recibos.get(i));
	    	 periodoEnDias = restaDeFechas(fechaDscto, fechaVcto);
	    	 nuevoDetalle.setNumeroPeriodoDias(periodoEnDias);
	    	 double valorNominal = recibos.get(i).getMontoNeto();
	    	
	    	 
	    	
	    	pDscto = HallarTasaDescuento(TEA, periodoEnDias ,valorNominal);
	    	nuevoDetalle.setPorcentajeTasaDescontada(pDscto); 	
	    	
	    	dscto = HallarValorDescuento(pDscto,valorNominal);
	    	nuevoDetalle.setMontoDescontado(dscto);
	    
	    	valorNeto = HallarValorNeto(dscto, valorNominal);
	    	nuevoDetalle.setMontoValorNeto(valorNeto);
	    	
	    	 valorRecibido = HallaElValorRecibido (dscto, valorNominal, valorNeto, pSegDesg, factoring.getMontoPortes(), factoring.getMontoITF());
	    	 nuevoDetalle.setMontoValorRecibido(valorRecibido); 
	    	 
	    	 valorRecibidoTotal += nuevoDetalle.getMontoValorRecibido();
	    
	    	 nuevoDetalle.setMontoValorEntregado(valorNominal);
	    	  
	    	 
	    	 nuevoDetalle.setTcea(HallarLaTcea(valorRecibido, valorNominal, periodoEnDias));
	    	 
	    	 listaDetalles.add(nuevoDetalle);
	    	 nuevoDetalle = null;
	    	 
	     }
	     double vt = valorRecibidoTotal;
	     
	     rf.setMontoTotalRecibido(vt);
	     
	     double tceaTotal = HallarTCEATotalDeCartera(listaDetalles, rf.getMontoTotalRecibido());
	     rf.setTceaTotal(tceaTotal);
	     
	     ResultadoFactoring factRes = resFactRepo.save(rf);
	     
	     for(int i = 0; i < recibos.size(); i++) {
	    	 listaDetalles.get(i).setResultadoFactoring(rf);
	    	  DetalleFactoring x = listaDetalles.get(i);
	    	 detalleFactoringRepository.save(x);
	     }
	     
	     return factRes;
	     
	  
	     
	 
	        
		
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
