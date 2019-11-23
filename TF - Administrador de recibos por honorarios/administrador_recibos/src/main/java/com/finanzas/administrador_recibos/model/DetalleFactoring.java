package com.finanzas.administrador_recibos.model;

import java.io.Serializable;


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
    @JoinColumn(name="id_Resultado_factoring")
    private ResultadoFactoring resultadoFactoring;
	
    @ManyToOne 
    @JoinColumn(name="id_recibo")
    private ReciboHonorarios reciboHonorarios;

    @Column(name = "TCEA",  nullable = false)
    private double tcea; 
    
    @Column(name = "M_Valor_Recibido", length = 7, nullable = false)
    private double montoValorRecibido; 

    @Column(name = "M_Valor_Entregado", length = 7, nullable = false)
    private double montoValorEntregado;

    @Column(name = "M_Descontado", length = 7, nullable = false)
    private double montoDescontado;

    @Column(name = "P_Tasa_Descontada",  nullable = false)
    private double porcentajeTasaDescontada;

    @Column(name = "M_Valor_Neto", length = 7, nullable = false)
    private double montoValorNeto;

    @Column(name = "N_Periodo_Dias", length = 7, nullable = false)
    private int numeroPeriodoDias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public ResultadoFactoring getResultadoFactoring() {
		return resultadoFactoring;
	}

	public void setResultadoFactoring(ResultadoFactoring resultadoFactoring) {
		this.resultadoFactoring = resultadoFactoring;
	}

	public ReciboHonorarios getReciboHonorarios() {
		return reciboHonorarios;
	}

	public void setReciboHonorarios(ReciboHonorarios reciboHonorarios) {
		this.reciboHonorarios = reciboHonorarios;
	}

	public double getTcea() {
		return tcea;
	}

	public void setTcea(double tcea) {
		this.tcea = tcea;
	}

	public double getMontoValorRecibido() {
		return montoValorRecibido;
	}

	public void setMontoValorRecibido(double montoValorRecibido) {
		this.montoValorRecibido = montoValorRecibido;
	}

	public double getMontoValorEntregado() {
		return montoValorEntregado;
	}

	public void setMontoValorEntregado(double montoValorEntregado) {
		this.montoValorEntregado = montoValorEntregado;
	}

	public double getMontoDescontado() {
		return montoDescontado;
	}

	public void setMontoDescontado(double montoDescontado) {
		this.montoDescontado = montoDescontado;
	}

	public double getPorcentajeTasaDescontada() {
		return porcentajeTasaDescontada;
	}

	public void setPorcentajeTasaDescontada(double porcentajeTasaDescontada) {
		this.porcentajeTasaDescontada = porcentajeTasaDescontada;
	}

	public double getMontoValorNeto() {
		return montoValorNeto;
	}

	public void setMontoValorNeto(double montoValorNeto) {
		this.montoValorNeto = montoValorNeto;
	}

	public int getNumeroPeriodoDias() {
		return numeroPeriodoDias;
	}

	public void setNumeroPeriodoDias(int numeroPeriodoDias) {
		this.numeroPeriodoDias = numeroPeriodoDias;
	}
    
    
}
