package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.Emisor;

@Repository

public interface EmisorRepository extends JpaRepository <Emisor, Integer> {
	@Query("select count(c.nombres) from Emisor c where c.nombres =:nombres")
	
	public int buscarNombreEmisor(@Param("nombres") String nombres);

	@Query("select e.id from Emisor e where e.nombreUsuario = :name and e.contrasena = :contraseña")
	public Integer verificarEmisor(@Param("name")String name,@Param("contraseña")String contrasena);
	
}
