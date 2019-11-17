package com.finanzas.administrador_recibos.service.implementation;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.administrador_recibos.dao.FactoringRepository;
import com.finanzas.administrador_recibos.dao.TipoTasaRepository;
import com.finanzas.administrador_recibos.model.Capitalizacion;
import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.model.Factoring;
import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.model.TipoTasa;
import com.finanzas.administrador_recibos.service.FactoringService;


@Service
public class FactoringServiceImpl implements FactoringService{

	@Override
	public List<DetalleFactoring> calcularFactoring(List<ReciboHonorarios> listaRecibos, Factoring factoring)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private FactoringRepository factoringRepository;
	
	@Autowired
	private TipoTasaRepository tipoTasaRepository;
	
	

    public BigDecimal ConversionTNAaTEA(TipoTasa tipoTasa, Capitalizacion capitalizacion, double valorTasaNominal) {
	
	double mN = 360/capitalizacion.getNumDias();
	double TEAdouble = (Math.pow(1 + valorTasaNominal/mN ,mN) - 1)*100;
	BigDecimal TEA = BigDecimal.valueOf(TEAdouble);
	return TEA;
    }
    
    public BigDecimal HallarTasaDescuento(BigDecimal TEA, Date fechaDscto, Date fechaVcto, BigDecimal valorNominal ) {
    	
    	
		int periodoEnDias= (int) ((fechaVcto.getTime()-fechaDscto.getTime())/86400000);
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
    
    
    public BigDecimal HallaElValorRecibido (BigDecimal descuento, BigDecimal valorNominal, BigDecimal ValorNeto, String tipoMoneda, BigDecimal segDesg, BigDecimal porte, BigDecimal itf)
    {
    	double van = ValorNeto.doubleValue();
    	
    	
    	double port = porte.doubleValue();
    	double it = itf.doubleValue();
    	double sgDg = (segDesg.doubleValue()/100)*valorNominal.doubleValue();
    	if (tipoMoneda == "Dólares")
    	{
           port = 1.00;
           it = 5.00;
    	}
    	else {
    		if (tipoMoneda == "Soles")
    		{
    			port = 2.50;
    			it = 5.00;
    		}
    	}
    	double valorReci = van - sgDg - port - it;
    	return BigDecimal.valueOf(valorReci);
    }
    
    
    public BigDecimal HallarElValorEntregado (BigDecimal valorNominal)
    {
    	double valorEntregado = valorNominal.doubleValue();
        
        return BigDecimal.valueOf(valorEntregado);
     
    }
    
    public BigDecimal HallarLaTcea (BigDecimal valorRecibido, BigDecimal valorEntregado, Date fchaDsct, Date fechaVcto)
    {
		int periodoEnDias= (int) ((fechaVcto.getTime()-fchaDsct.getTime())/86400000);
		double TCEA = Math.pow((valorEntregado.doubleValue()/valorRecibido.doubleValue()), (360/periodoEnDias))-1;
    	return BigDecimal.valueOf(TCEA);
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
	public Factoring registrarFactoring(Factoring factoring, String tipoTasa, String capitalizacion, List<ReciboHonorarios> recibos) throws Exception {
	   //TODO: Implementar el registrar Factoring
		return new Factoring();
	}

	@Override
	public Factoring EncontrarPorID(Factoring factoring) {
		// TODO Auto-generated method stub
		return factoringRepository.findById(factoring.getId()).get();
	}



	
	
}


