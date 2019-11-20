package com.finanzas.administrador_recibos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.administrador_recibos.dao.DetalleFactoringRepository;
import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.service.DetalleFactoringService;

@Service
public class DetalleFactoringServiceImpl implements DetalleFactoringService{
	

	@Autowired
	private DetalleFactoringRepository detalleFactoringRepository;
	
	
	@Override
	public List<DetalleFactoring> listar() {
		return detalleFactoringRepository.findAll();
	}

	@Override
	public DetalleFactoring registrarDetalleFactoring(DetalleFactoring detallefactoring) throws Exception {
		return detalleFactoringRepository.save(detallefactoring);
		
	}

	@Override
	public DetalleFactoring EncontrarPorID(DetalleFactoring detallefactoring) {
		// TODO Auto-generated method stub
		return detalleFactoringRepository.findById(detallefactoring.getId()).get();
	}

	@Override
	public Integer insert(DetalleFactoring detallefactoring) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DetalleFactoring> listarPorFactoring(Integer factoringId){
		return detalleFactoringRepository.listarPorFactoring(factoringId);
	}
}


