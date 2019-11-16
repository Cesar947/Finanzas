package com.finanzas.administrador_recibos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Capitalizacion")
@NoArgsConstructor
@AllArgsConstructor
public class Capitalizacion {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Capitalizacion", length = 2, nullable = false)
    private Integer id;
	
	 @Column(name = "T_Descripcion", length = 2, nullable = false)
	 private String descripcion;
	 
	 @Column(name = "N_dias", length = 2, nullable = false)
	 private int numDias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	
	
}
