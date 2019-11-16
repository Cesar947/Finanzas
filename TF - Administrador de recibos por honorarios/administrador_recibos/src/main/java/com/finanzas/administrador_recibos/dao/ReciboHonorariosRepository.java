package com.finanzas.administrador_recibos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.ReciboHonorarios;

@Repository
public interface ReciboHonorariosRepository extends JpaRepository<ReciboHonorarios, Integer>  {
	
	@Query("select c from ReciboHonorarios c JOIN Emisor d on c.emisor.id = d.id where c.emisor.id = :id ")
	List<ReciboHonorarios> findRecibo(@Param("id") String id);	
}
