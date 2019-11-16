package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.DetalleFactoring;
import com.finanzas.administrador_recibos.model.Factoring;
import com.finanzas.administrador_recibos.model.ReciboHonorarios;

public interface FactoringService {
		public Integer insert(Factoring factoring);
		public List<Factoring> listar();	
		Factoring registrarFactoring(Factoring factoring, String tipoTasa, String capitalizacion, List<ReciboHonorarios> recibos) throws Exception;
		public Factoring EncontrarPorID(Factoring factoring);
        public List<DetalleFactoring> calcularFactoring(List<ReciboHonorarios> listaRecibos, Factoring factoring) throws Exception;

}
