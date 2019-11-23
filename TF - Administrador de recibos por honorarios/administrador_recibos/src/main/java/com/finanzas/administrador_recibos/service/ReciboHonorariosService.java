package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.ReciboHonorarios;

public interface ReciboHonorariosService {
	
	public List<ReciboHonorarios> listarTodo();	
	
	public ReciboHonorarios registrarReciboPorHonorarios(ReciboHonorarios recibo, Integer emisorId
    		, Integer clienteId) throws Exception;
	
	public ReciboHonorarios EncontrarPorID(String reciboId);
 
	
	
}
