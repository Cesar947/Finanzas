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

    public double ConversionTNAaTEA(Capitalizacion capitalizacion, double valorTasaNominal) {
	
	double mN = 360/capitalizacion.getNumDias();
	double TEA = (Math.pow(1 + valorTasaNominal/mN ,mN) - 1)*100;
	
	return TEA;
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
	public Factoring registrarFactoring(Factoring factoring, String tipoTasa, String capitalizacion, double pSegDesg, String tipoMoneda) throws Exception {
	    
	
		 System.out.println(tipoMoneda);
		 tipoTasa = tipoTasa.toUpperCase();
		 
		 
	
		 if(tipoTasa.equals("EFECTIVA") || capitalizacion == null) {
			 capitalizacion = "";
		 }
		 else {
			 capitalizacion = capitalizacion.toUpperCase();
			  factoring.setCapitalizacion(capitalizacionRepository.obtenerPorDescripcion(capitalizacion));
		 }
		 factoring.setPorcentajeDesgravamen(pSegDesg);
	     factoring.setTipoTasa(tipoTasaRepository.obtenerPorDescripcion(tipoTasa));
	   
	     if(tipoMoneda.equals("Soles")) {
	    	 factoring.setTipoMoneda("Soles");
	    	 factoring.setMontoPortes(2.50);
	    	 factoring.setMontoITF(5.00);
	     }
	     else if(tipoMoneda.equals("Dólares")){
	    	 factoring.setTipoMoneda("Dólares");
	    	 factoring.setMontoPortes(1.00);
	    	 factoring.setMontoITF(1.50);
	     }
	     else {
	    	 return new Factoring();
	     }
	    	 
	     double TEA = 0.00;
	     
	     if(!(capitalizacion == "")) {
	    	 TEA = ConversionTNAaTEA(factoring.getCapitalizacion(), factoring.getPorcentajeTasaFactoring());
	    	 factoring.setPorcentajeTasaFactoring(TEA);
	     }
	   
	     
	     return this.factoringRepository.save(factoring);
	    
	}

	@Override
	public Factoring EncontrarPorID(Integer id) {
		// TODO Auto-generated method stub
		return factoringRepository.findById(id).get();
	}



	
	
}


