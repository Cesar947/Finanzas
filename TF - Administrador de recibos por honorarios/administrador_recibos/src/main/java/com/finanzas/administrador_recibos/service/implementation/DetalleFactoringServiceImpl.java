package com.finanzas.administrador_recibos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.finanzas.administrador_recibos.dao.DetalleFactoringRepository;
import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.service.DetalleFactoringService;

public class DetalleFactoringServiceImpl implements DetalleFactoringService{
	

	@Autowired
	private DetalleFactoringRepository detallefactoringRepository;
	
	
	@Override
	public List<DetalleFactoring> listar() {
		return detallefactoringRepository.findAll();
	}

	@Override
	public DetalleFactoring registrarDetalleFactoring(DetalleFactoring detallefactoring) throws Exception {
		return detallefactoringRepository.save(detallefactoring);
		
	}

	@Override
	public DetalleFactoring EncontrarPorID(DetalleFactoring detallefactoring) {
		// TODO Auto-generated method stub
		return detallefactoringRepository.findById(detallefactoring.getId()).get();
	}

	@Override
	public Integer insert(DetalleFactoring detallefactoring) {
		// TODO Auto-generated method stub
		return null;
	}
}


