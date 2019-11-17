package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.TipoTasa;

@Repository
public interface TipoTasaRepository extends JpaRepository<TipoTasa,Integer> {

@Query("SELECT t FROM TipoTasa t where t.descripcion =: descripcion")
TipoTasa obtenerPorDescripcion(@Param("descripcion") String descripcion) throws Exception;
}
