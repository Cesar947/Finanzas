package com.finanzas.administrador_recibos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.service.DetalleFactoringService;


@RestController
@RequestMapping("/detallefactoring")
public class DetalleFactoringController {
	private DetalleFactoringService detallefactoringService;

	@Autowired
	public DetalleFactoringController(DetalleFactoringService detallefactoringService) {
		this.detallefactoringService = detallefactoringService;

	}

	@RequestMapping(path = "/detallefactoring/{id}", method = RequestMethod.POST)
	public DetalleFactoring registrarDetalleFactoring(@RequestBody DetalleFactoring detallefactoring) throws Exception {
		return detallefactoringService.registrarDetalleFactoring(detallefactoring);
	}
	@RequestMapping(path = "/detallefactoring", method = RequestMethod.GET)
	public List<DetalleFactoring> listar() {
		return detallefactoringService.listar();
	}
	
}
	
