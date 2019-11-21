package com.finanzas.administrador_recibos.service;

import java.math.BigDecimal;
import java.util.List;

import com.finanzas.administrador_recibos.model.Factoring;

public interface FactoringService {
		public Integer insert(Factoring factoring);
		public List<Factoring> listar();	
		public Factoring registrarFactoring(Factoring factoring, String tipoTasa, String capitalizacion, BigDecimal pSegDesg, String tipoMoneda) throws Exception;
		public Factoring EncontrarPorID(Factoring factoring);
       // public List<DetalleFactoring> calcularFactoring(List<ReciboHonorarios> listaRecibos, Factoring factoring) throws Exception;

}
