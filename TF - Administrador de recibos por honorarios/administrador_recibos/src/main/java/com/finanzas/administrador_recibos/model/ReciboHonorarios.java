package com.finanzas.administrador_recibos.model;

import java.io.Serializable;
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

@NoArgsConstructor
@AllArgsConstructor
public class ReciboHonorarios implements Serializable{

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getMontoHonorarios() {
		return montoHonorarios;
	}

	public void setMontoHonorarios(BigDecimal montoHonorarios) {
		this.montoHonorarios = montoHonorarios;
	}

	public BigDecimal getRetencionIR() {
		return retencionIR;
	}

	public void setRetencionIR(BigDecimal retencionIR) {
		this.retencionIR = retencionIR;
	}

	public BigDecimal getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(BigDecimal montoNeto) {
		this.montoNeto = montoNeto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	public BigDecimal getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(BigDecimal tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	
	
	
	
}
