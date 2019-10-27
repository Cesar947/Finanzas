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
	private int apellidos;
	
	@Column(name="N_RUC", length = 11, nullable = false)
	private int ruc;
	
	@Column(name="N_Direccion", length = 100, nullable = false)
	private int direccion;
	
	@Column(name="N_Telefono", length = 10, nullable = false)
	private int telefono;
	
	@Column(name="T_Nombre_Usuario", length = 50, nullable = false)
	private int nombre_usuario;
	
	@Column(name="T_Contrasena", length = 50, nullable = false)
	private int contrasena;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getApellidos() {
		return apellidos;
	}

	public void setApellidos(int apellidos) {
		this.apellidos = apellidos;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(int nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public int getContrasena() {
		return contrasena;
	}

	public void setContrasena(int contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
