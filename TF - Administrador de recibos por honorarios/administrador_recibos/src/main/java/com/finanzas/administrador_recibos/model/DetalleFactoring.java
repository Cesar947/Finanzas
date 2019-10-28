package com.finanzas.administrador_recibos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Detalle_Factoring")
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactoring implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Detalle", length = 7, nullable = false)
    private Integer id;
	
    @ManyToOne 
    @JoinColumn(name="id_Factoring")
    private Factoring factoring;
	
    @ManyToOne 
    @JoinColumn(name="id_Codigo")
    private ReciboHonorarios reciboHonorarios;

    @Column(name = "TCEA", length = 7, nullable = false)
    private BigDecimal tcea; 
    
    @Column(name = "M_Valor_Recibido", length = 7, nullable = false)
    private BigDecimal montoValorRecibido; 

    @Column(name = "M_Valor_Entregado", length = 7, nullable = false)
    private BigDecimal montoValorEntregado;

    @Column(name = "M_Descontado", length = 7, nullable = false)
    private BigDecimal montoDescontado;

    @Column(name = "P_Tasa_Descontada", length = 7, nullable = false)
    private BigDecimal porcentajeTasaDescontada;

    @Column(name = "M_Valor_Neto", length = 7, nullable = false)
    private int montoValorNeto;

    @Column(name = "N_Periodo_Dias", length = 7, nullable = false)
    private int numeroPeriodoDias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Factoring getFactoring() {
		return factoring;
	}

	public void setFactoring(Factoring factoring) {
		this.factoring = factoring;
	}

	public ReciboHonorarios getReciboHonorarios() {
		return reciboHonorarios;
	}

	public void setReciboHonorarios(ReciboHonorarios reciboHonorarios) {
		this.reciboHonorarios = reciboHonorarios;
	}

	public BigDecimal getTcea() {
		return tcea;
	}

	public void setTcea(BigDecimal tcea) {
		this.tcea = tcea;
	}

	public BigDecimal getMontoValorRecibido() {
		return montoValorRecibido;
	}

	public void setMontoValorRecibido(BigDecimal montoValorRecibido) {
		this.montoValorRecibido = montoValorRecibido;
	}

	public BigDecimal getMontoValorEntregado() {
		return montoValorEntregado;
	}

	public void setMontoValorEntregado(BigDecimal montoValorEntregado) {
		this.montoValorEntregado = montoValorEntregado;
	}

	public BigDecimal getMontoDescontado() {
		return montoDescontado;
	}

	public void setMontoDescontado(BigDecimal montoDescontado) {
		this.montoDescontado = montoDescontado;
	}

	public BigDecimal getPorcentajeTasaDescontada() {
		return porcentajeTasaDescontada;
	}

	public void setPorcentajeTasaDescontada(BigDecimal porcentajeTasaDescontada) {
		this.porcentajeTasaDescontada = porcentajeTasaDescontada;
	}

	public int getMontoValorNeto() {
		return montoValorNeto;
	}

	public void setMontoValorNeto(int montoValorNeto) {
		this.montoValorNeto = montoValorNeto;
	}

	public int getNumeroPeriodoDias() {
		return numeroPeriodoDias;
	}

	public void setNumeroPeriodoDias(int numeroPeriodoDias) {
		this.numeroPeriodoDias = numeroPeriodoDias;
	}
    
    
}
