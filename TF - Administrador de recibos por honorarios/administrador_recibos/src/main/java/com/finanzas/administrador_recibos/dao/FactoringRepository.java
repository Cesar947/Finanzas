package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.Factoring;

@Repository
public interface FactoringRepository extends JpaRepository<Factoring, Integer>{
 
}
