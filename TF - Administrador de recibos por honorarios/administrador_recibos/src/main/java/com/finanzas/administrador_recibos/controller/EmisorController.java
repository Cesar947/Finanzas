package com.finanzas.administrador_recibos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Emisor registrarEmisor(@RequestBody Emisor emisor) {
		return emisorService.registrarEmisor(emisor);
	}
	
	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	public List<Emisor> listarEmisores(Emisor emisor) throws Exception{
		return emisorService.listarEmisores();
	}
	
	@RequestMapping(path = "/iniciarRUC", method = RequestMethod.GET)
	public Integer verificarEmisorPorRuc(@RequestParam(name = "usuario", required = true) String name, 
			@RequestParam(name = "contraseña", required = true) String contraseña,
			@RequestParam(name = "ruc", required = true) String ruc) {
		return emisorService.verificarEmisor(name, contraseña, ruc);
	}
	
	@RequestMapping(path = "/iniciarDNI", method = RequestMethod.GET)
	public Integer verificarEmisorPorDNI(@RequestParam(name = "usuario", required = true) String name, 
			@RequestParam(name = "contraseña", required = true) String contraseña,
			@RequestParam(name = "DNI", required = true) int DNI) {
		return emisorService.verificarEmisorDNI(name, contraseña, DNI);
	}
	
	
	
}
