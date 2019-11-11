package com.finanzas.administrador_recibos.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.administrador_recibos.dao.EmisorRepository;
import com.finanzas.administrador_recibos.model.Emisor;
import com.finanzas.administrador_recibos.service.EmisorService;

@Service
public class EmisorServiceImpl implements EmisorService{

	@Autowired
	private EmisorRepository emisorRepository;
	
	@Override
	@Transactional
	public Emisor registrarEmisor(Emisor emisor) {
		// TODO Auto-generated method stub
		Emisor nuevo = new Emisor();
		int rpta = emisorRepository.buscarNombreEmisor(emisor.getNombres());
		if (rpta == 0) {
			nuevo = emisorRepository.save(emisor);
		}
		return nuevo;
	}


}
