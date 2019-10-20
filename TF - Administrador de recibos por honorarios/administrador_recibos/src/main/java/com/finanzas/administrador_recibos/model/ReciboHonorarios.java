package com.finanzas.administrador_recibos.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Recibo_Honorarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReciboHonorarios {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Codigo", length = 8, nullable = false)
    private String id;
	
	@Column(name="D_Emision", nullable = false)
    private Date fechaEmision;
	
	@Column(name="D_Vencimiento", nullable = false)
    private Date fechaVencimiento;
	
	@Column(name="M_Honorarios", length = 15, nullable = false)
    private BigDecimal montoHonorarios;
	
	@Column(name="M_Retencion_IR", length = 15, nullable = false)
    private BigDecimal retencionIR;
	
	@Column(name="M_Honorarios_Neto", length = 15, nullable = false)
    private BigDecimal montoNeto;
	
	@ManyToOne
	@JoinColumn(name = "id_Cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_Emisor")
	private Emisor emisor;
	
	@Column(name="T_Tipo_Moneda", length = 8, nullable = false)
    private BigDecimal tipoMoneda;
	
	
	
}
