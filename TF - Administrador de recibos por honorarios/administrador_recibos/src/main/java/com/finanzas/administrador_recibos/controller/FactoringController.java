package com.finanzas.administrador_recibos.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.administrador_recibos.model.Factoring;
import com.finanzas.administrador_recibos.service.FactoringService;

@RestController
@RequestMapping("/factoring")
public class FactoringController {
	private FactoringService factoringService;

	@Autowired
	public FactoringController(FactoringService factoringService) {
		this.factoringService = factoringService;

	}
	
	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	public List<Factoring> listar() {
		return this.factoringService.listar();
	}
	
	@RequestMapping(path = "/registro", method = RequestMethod.POST)
	public Factoring registrarFactoring(@RequestBody Factoring factoring,
			@RequestParam(name = "tipoTasa", required = true) String tipoTasa, 
			@RequestParam(name = "capitalizacion", required = false) String capitalizacion, 
			@RequestParam(name = "pSegDesg", required = true) BigDecimal pSegDesg, 
			@RequestParam(name = "tipoMoneda", required = true) String tipoMoneda) throws Exception{
		
		return this.factoringService.registrarFactoring(factoring, tipoTasa, capitalizacion, pSegDesg, tipoMoneda);
	}


}
