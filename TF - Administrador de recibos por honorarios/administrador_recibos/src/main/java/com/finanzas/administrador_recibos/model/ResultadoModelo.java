package com.finanzas.administrador_recibos.model;

import java.util.List;

public class ResultadoModelo {

	List<DetalleFactoring> detalles;
	
	ResultadoFactoring resultado;

	public List<DetalleFactoring> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactoring> detalles) {
		this.detalles = detalles;
	}

	public ResultadoFactoring getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoFactoring resultado) {
		this.resultado = resultado;
	}
	
	
	
}
