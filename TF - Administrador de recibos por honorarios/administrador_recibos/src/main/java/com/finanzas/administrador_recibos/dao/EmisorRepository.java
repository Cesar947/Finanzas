package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.Emisor;

@Repository
public interface EmisorRepository extends JpaRepository<Emisor, Integer>{

	
}
