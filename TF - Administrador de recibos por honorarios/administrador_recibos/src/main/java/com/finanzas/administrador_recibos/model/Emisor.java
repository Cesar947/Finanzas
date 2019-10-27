package com.finanzas.administrador_recibos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Emisor")
@NoArgsConstructor
@AllArgsConstructor
public class Emisor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Emisor", length = 7, nullable = false)
    private Integer id;
	
	@Column(name="N_DNI", length = 50, nullable = false)
    private int dni;
	
	@Column(name="N_Nombres", length = 50, nullable = false)
	private String nombres;
	
	@Column(name="N_Apellidos", length = 50, nullable = false)
	private String apellidos;
	
	@Column(name="N_RUC", length = 11, nullable = false)
	private String ruc;
	
	@Column(name="N_Direccion", length = 100, nullable = false)
	private String direccion;
	
	@Column(name="N_Telefono", length = 10, nullable = false)
	private int telefono;
	
	@Column(name="T_Nombre_Usuario", length = 50, nullable = false)
	private String nombre_usuario;
	
	@Column(name="T_Contrasena", length = 50, nullable = false)
	private String contrasena;
	
	
	
}
