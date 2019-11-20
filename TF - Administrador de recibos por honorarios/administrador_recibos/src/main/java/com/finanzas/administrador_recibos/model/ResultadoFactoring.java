package com.finanzas.administrador_recibos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name="resultado_factoring")
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoFactoring {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Resultado_factoring", length = 7, nullable = false)
    private Integer id;
	
	
	
}
