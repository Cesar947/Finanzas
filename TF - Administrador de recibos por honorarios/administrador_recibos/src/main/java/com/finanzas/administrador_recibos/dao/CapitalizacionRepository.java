package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finanzas.administrador_recibos.model.Capitalizacion;
import com.finanzas.administrador_recibos.model.TipoTasa;

public interface CapitalizacionRepository extends JpaRepository<Capitalizacion, Integer> {

	@Query("SELECT c FROM Capitalizacion c where c.descripcion =: descripcion")
	Capitalizacion obtenerPorDescripcion(@Param("descripcion") String descripcion) throws Exception;
	
}
