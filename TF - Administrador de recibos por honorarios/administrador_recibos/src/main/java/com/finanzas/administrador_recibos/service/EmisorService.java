package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.Emisor;

public interface EmisorService {
	public Emisor registrarEmisor(Emisor emisor);
	
	public List<Emisor> listarEmisores() throws Exception;
	
	public Integer verificarEmisor(String name, String contrasena, String RUC);
	
	public Integer verificarEmisorDNI(String name, String contrasena, int dni);
	
	
}
