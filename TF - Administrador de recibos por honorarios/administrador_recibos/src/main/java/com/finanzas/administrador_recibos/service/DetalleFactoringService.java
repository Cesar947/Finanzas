package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.DetalleFactoring;

public interface DetalleFactoringService {
	
	public Integer insert(DetalleFactoring detallefactoring);
	public List<DetalleFactoring> listar();
	DetalleFactoring registrarDetalleFactoring(DetalleFactoring detallefactoring)throws Exception;
	public DetalleFactoring EncontrarPorID(DetalleFactoring detallefactoring);
	

}
