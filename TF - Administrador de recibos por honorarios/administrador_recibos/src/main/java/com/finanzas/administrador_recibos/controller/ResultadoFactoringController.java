package com.finanzas.administrador_recibos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.model.ResultadoFactoring;
import com.finanzas.administrador_recibos.model.ResultadoModelo;
import com.finanzas.administrador_recibos.service.ResultadoFactoringService;

@RestController
@RequestMapping(path = "/resultadoFactoring")
public class ResultadoFactoringController {

	
    private ResultadoFactoringService resultadoFactoringService;
	
	@Autowired
	public ResultadoFactoringController(ResultadoFactoringService resultadoFactoringService) {
		this. resultadoFactoringService =  resultadoFactoringService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResultadoModelo mostrarResultado(Integer factId) {
		return resultadoFactoringService.mostrarCalculos(factId);
	}
	
	@RequestMapping(path = "/Calculando", method = RequestMethod.POST)
	public ResultadoFactoring calcularFactoring(List<ReciboHonorarios> recibos,
			@RequestParam(name = "factId", required = true) Integer factId) {
		return resultadoFactoringService.CalcularResultado(recibos, factId);
	}
	
	
}
