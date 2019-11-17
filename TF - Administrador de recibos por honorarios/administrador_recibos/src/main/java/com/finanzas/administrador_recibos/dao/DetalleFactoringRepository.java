package com.finanzas.administrador_recibos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.DetalleFactoring;

@Repository
public interface DetalleFactoringRepository extends JpaRepository<DetalleFactoring, Integer> {
   
	@Query("SELECT d FROM DetalleFactoring d WHERE d.factoring.id =: id")
	List<DetalleFactoring> listarPorFactoring(@Param("id") Integer factoringId);

}


