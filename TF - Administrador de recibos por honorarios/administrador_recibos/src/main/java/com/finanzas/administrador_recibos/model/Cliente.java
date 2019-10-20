package com.finanzas.administrador_recibos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cliente", length = 11, nullable = false)
    private Integer id;
	
	@Column(name="N_RUC", length = 9, nullable = false)
    private int ruc;
	
	@Column(name="T_Nombre", length = 50, nullable = false)
    private int nombre;
	
}
