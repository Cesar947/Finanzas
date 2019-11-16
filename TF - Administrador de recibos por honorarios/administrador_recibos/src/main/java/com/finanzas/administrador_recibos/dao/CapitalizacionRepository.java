package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.administrador_recibos.model.Capitalizacion;

public interface CapitalizacionRepository extends JpaRepository<Capitalizacion, Integer> {

}
