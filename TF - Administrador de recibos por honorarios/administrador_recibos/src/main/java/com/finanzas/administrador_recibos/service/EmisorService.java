package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.Emisor;

public interface EmisorService {
	public Emisor registrarEmisor(Emisor emisor);
	
	public List<Emisor> listarEmisores() throws Exception;
}
