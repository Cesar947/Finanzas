package com.finanzas.administrador_recibos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.administrador_recibos.model.Emisor;
import com.finanzas.administrador_recibos.service.EmisorService;

@RestController
@RequestMapping("/emisor")
public class EmisorController {

	private EmisorService emisorService;
	
	@Autowired
	public EmisorController(EmisorService emisorService) {
		this.emisorService = emisorService;
	}
	
	@RequestMapping(path = "/registro", method = RequestMethod.POST)
	public Emisor registrarEmisor(Emisor emisor) {
		return emisorService.registrarEmisor(emisor);
	}
}
