package com.finanzas.administrador_recibos.service;

//import java.util.List;

import com.finanzas.administrador_recibos.model.TipoTasa;

public interface TipoTasaService {

	TipoTasa registrarTipoTasa(TipoTasa tasa) throws Exception;
	
	public TipoTasa EncontrarPorID(Integer tasaid);
}
