package com.finanzas.administrador_recibos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tipo_Tasa")
@NoArgsConstructor
@AllArgsConstructor
public class TipoTasa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Tipo_Tasa", length = 7, nullable = false)
    private Integer id;
	
	@Column(name="T_Descripcion", length = 12, nullable = false)
    private String descripcion;

	@Column(name="T_Capitalizacion", length = 20, nullable = true)
    private String tasaCapitalizacion;

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

	public String getTasaCapitalizacion() {
		return tasaCapitalizacion;
	}

	public void setTasaCapitalizacion(String tasaCapitalizacion) {
		this.tasaCapitalizacion = tasaCapitalizacion;
	}
	
	
}
