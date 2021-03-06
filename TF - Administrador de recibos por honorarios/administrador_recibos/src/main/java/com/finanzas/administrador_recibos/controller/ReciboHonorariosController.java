package com.finanzas.administrador_recibos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.service.ReciboHonorariosService;

@RestController
@RequestMapping("/recibosHonorarios")
public class ReciboHonorariosController  {
	private ReciboHonorariosService reciboporhonorarioservice;
	
	@Autowired
	public ReciboHonorariosController(ReciboHonorariosService reciboporhonorarioservice) {
		this.reciboporhonorarioservice = reciboporhonorarioservice;
	}
	
	@RequestMapping(path = "/registro/{emisorId}/{clienteId}", method = RequestMethod.POST)
	public ReciboHonorarios RegistrarReciboPorHonorario(@RequestBody ReciboHonorarios recibohonorario,
			@PathVariable Integer emisorId, @PathVariable Integer clienteId) throws Exception{
		return reciboporhonorarioservice.registrarReciboPorHonorarios(recibohonorario, emisorId, clienteId);

	}
	
	@RequestMapping(path = "/emisor/{emisorId}",method = RequestMethod.GET)
	public List<ReciboHonorarios> listar(@PathVariable Integer emisorId) {
		//return reciboporhonorarioservice.listar(emisorId);
	    
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ReciboHonorarios> listarTodo(){
		return reciboporhonorarioservice.listarTodo();
	}
	
	@RequestMapping(path = "/{reciboId}", method = RequestMethod.GET)
	public ReciboHonorarios listarPorId(@PathVariable String reciboId) {
		return reciboporhonorarioservice.EncontrarPorID(reciboId);
	}
		
}
