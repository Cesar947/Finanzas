package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.ReciboHonorarios;

public interface ReciboHonorariosService {
	
	public List<ReciboHonorarios> listar();	
	
	public ReciboHonorarios registrarReciboPorHonorarios(ReciboHonorarios recibo) throws Exception;
	
	public ReciboHonorarios EncontrarPorID(ReciboHonorarios reciboHonorarios);
 
	
	
}
