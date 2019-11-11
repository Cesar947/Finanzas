package com.finanzas.administrador_recibos.service;

import java.util.List;


import com.finanzas.administrador_recibos.model.Factoring;
public interface FactoringService {
		public Integer insert(Factoring factoring);
		public List<Factoring> listar();	
		Factoring registrarFactoring(Factoring factoring) throws Exception;
		public Factoring EncontrarPorID(Factoring factoring);


}
