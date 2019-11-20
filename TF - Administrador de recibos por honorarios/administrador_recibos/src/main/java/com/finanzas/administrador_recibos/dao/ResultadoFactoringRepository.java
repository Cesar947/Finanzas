package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.ResultadoFactoring;

@Repository
public interface ResultadoFactoringRepository extends JpaRepository<ResultadoFactoring, Integer> {

	@Query("SELECT rf FROM ResultadoFactoring rf WHERE rf.factoring.id = :factId")
	public ResultadoFactoring listarPorFactoring(@Param("factId") Integer factoringId);
}
