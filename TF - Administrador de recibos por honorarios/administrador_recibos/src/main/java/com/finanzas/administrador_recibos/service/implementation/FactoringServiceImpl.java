package com.finanzas.administrador_recibos.service.implementation;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.administrador_recibos.dao.CapitalizacionRepository;
import com.finanzas.administrador_recibos.dao.DetalleFactoringRepository;
import com.finanzas.administrador_recibos.dao.FactoringRepository;
import com.finanzas.administrador_recibos.dao.TipoTasaRepository;
import com.finanzas.administrador_recibos.model.Capitalizacion;
import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.model.Factoring;
import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.service.FactoringService;


@Service
public class FactoringServiceImpl implements FactoringService{

	

	@Autowired
	private FactoringRepository factoringRepository;
	
	@Autowired
	private TipoTasaRepository tipoTasaRepository;
	
	@Autowired
	private CapitalizacionRepository capitalizacionRepository;
	
	@Autowired
	private DetalleFactoringRepository detalleRepository;

    public BigDecimal ConversionTNAaTEA(Capitalizacion capitalizacion, BigDecimal valorTasaNominal) {
	
	double mN = 360/capitalizacion.getNumDias();
	double TEAdouble = (Math.pow(1 + valorTasaNominal.doubleValue()/mN ,mN) - 1)*100;
	BigDecimal TEA = BigDecimal.valueOf(TEAdouble);
	return TEA;
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
    	return BigDecimal.valueOf(TCEA);
    }
    
    public BigDecimal HallarTCEATotalDeCartera(List<DetalleFactoring> detalles) {
    
    	BigDecimal valorRecibidoTotal = new BigDecimal(0.00);
    	for(int i = 0; i < detalles.size(); i++) {
    		valorRecibidoTotal.add(detalles.get(i).getMontoValorRecibido());
    	}
    	BigDecimal TCEA = new BigDecimal(0.0);
    	int F = 1;
    	double I  = valorRecibidoTotal.doubleValue();
    	double a = 0;
    	double b = 0.8;
    	double val;
    	double c;
    	double denom;
    	double tirP = 0;
    	double tirA = 0;
    	for(int i = 0; i < 1000; i++) {
    		val = 0;
    		c = (a + b)/2;
    		for(int j = 0; j < detalles.size(); j++) {
    			denom = Math.pow((1 + c),detalles.get(j).getNumeroPeriodoDias());
    			val += detalles.get(i).getMontoValorEntregado().doubleValue()/denom;
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
    			TCEA = new BigDecimal(Math.pow(1 + tirA*(F/360), 360/F) - 1);
    			i = 1000;
    		}
    		
    	}
    	
    	return TCEA;
    	
    }
	
	@Override
	@Transactional
	public Integer insert(Factoring PorcentajeDesgravamen) {
		// TODO Auto-generated method stub
		int rpta = 0;//factoringRepository.buscarDesgravamenFactoring(PorcentajeDesgravamen.getPorcentajeDesgravamen());
		if (rpta == 0) {
			factoringRepository.save(PorcentajeDesgravamen);
		}
		return rpta;
	}

	@Override
	public List<Factoring> listar() {
		return factoringRepository.findAll();
	}
	
	
	

	@Override
	public List<DetalleFactoring> registrarYListarResultadosFactoring(Factoring factoring, String tipoTasa, String capitalizacion, double pSegDesg, List<ReciboHonorarios> recibos) throws Exception {
	    
		 DetalleFactoring nuevoDetalle = new DetalleFactoring();
		 List<DetalleFactoring> listaDetalles = new ArrayList<DetalleFactoring>();
		 int dol = 0;
		 int sol = 0;
		 if(tipoTasa == "efectiva") {
			 capitalizacion = "";
		 }
		 else {
			  factoring.setCapitalizacion(capitalizacionRepository.obtenerPorDescripcion(capitalizacion));
		 }
		 factoring.setPorcentajeDesgravamen(new BigDecimal(pSegDesg));
	     factoring.setTipoTasa(tipoTasaRepository.obtenerPorDescripcion(tipoTasa));
	   
	     for(int i = 0; i < recibos.size(); i++) {
	    	 if(recibos.get(i).getTipoMoneda() == "dólares") {
	    		 dol++;
	    	 }
	    	 else
	    		 sol++;
	     }
	     if(sol == recibos.size()) {
	    	 factoring.setMontoPortes(new BigDecimal(2.50));
	    	 factoring.setMontoITF(new BigDecimal(5.00));
	     }else {
	    	 factoring.setMontoPortes(new BigDecimal(1.00));
	    	 factoring.setMontoITF(new BigDecimal(1.50));
	     }
	     
	     BigDecimal TEA = new BigDecimal(0.00);
	     if(!(capitalizacion == "")) {
	    	 TEA = ConversionTNAaTEA(factoring.getCapitalizacion(), factoring.getPorcentajeTasaFactoring());
	     }
	     
	     Date fechaDscto = factoring.getFechaDescuento();
	     Date fechaVcto;
	     BigDecimal pDscto;
	     BigDecimal dscto;
	     BigDecimal valorNeto;
	     BigDecimal valorRecibido;
	     int periodoEnDias;
	     //EL FOR MAS MACHO DE TODOS LOS MACHOS
	     for(int i = 0; i < recibos.size(); i++) {
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
	    	
	    	valorRecibido = HallaElValorRecibido (dscto, valorNominal, valorNeto, new BigDecimal(pSegDesg), factoring.getMontoPortes(), factoring.getMontoITF());
	    	 nuevoDetalle.setMontoValorRecibido(valorRecibido); 
	    	 
	    
	    	 nuevoDetalle.setMontoValorEntregado(valorNominal);
	    	 
	    	 nuevoDetalle.setTcea(HallarLaTcea(valorRecibido, valorNominal, periodoEnDias));
	    	 
	    	 listaDetalles.add(nuevoDetalle);
	    	 nuevoDetalle = null;
	    	 
	     }
	     
	     BigDecimal tceaTotal = HallarTCEATotalDeCartera(listaDetalles);
	     factoring.setTceaTotal(tceaTotal);
	     
	     
	     for(int i = 0; i < listaDetalles.size(); i++) {
	    	 listaDetalles.get(i).setFactoring(factoring);
	    	 detalleRepository.save(listaDetalles.get(i));
	     }
	     
	     Factoring f = factoringRepository.save(factoring);
	     
	     return detalleRepository.listarPorFactoring(f.getId());
	     
	     //TODO: Pensar si podríamos validar que si hay algún factoring igual, no se guarde 
	        
		
	}

	@Override
	public Factoring EncontrarPorID(Factoring factoring) {
		// TODO Auto-generated method stub
		return factoringRepository.findById(factoring.getId()).get();
	}



	
	
}


