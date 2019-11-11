package com.finanzas.administrador_recibos.service.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.administrador_recibos.dao.FactoringRepository;
import com.finanzas.administrador_recibos.model.Factoring;
import com.finanzas.administrador_recibos.service.FactoringService;

@Service
public class FactoringServiceImpl implements FactoringService{

	@Autowired
	private FactoringRepository factoringRepository;
	
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
	public Factoring registrarFactoring(Factoring factoring) throws Exception {
		// TODO Auto-generated method stub
		return factoringRepository.save(factoring);
	}

	@Override
	public Factoring EncontrarPorID(Factoring factoring) {
		// TODO Auto-generated method stub
		return factoringRepository.findById(factoring.getId()).get();
	}


}


