package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.TipoTasa;

@Repository
public interface TipoTasaRepository extends JpaRepository<TipoTasa,Integer> {

	  @Query("SELECT t FROM TipoTasa t WHERE t.descripcion = ?1 AND t.capitalizacion = ?2")	
	   public TipoTasa encontrarPorDescripcionYCapitalizacion(String descripcion, String capitalizacion);
}
