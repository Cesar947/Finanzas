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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Recibo_Honorarios")
@NoArgsConstructor
@AllArgsConstructor
public class ReciboHonorarios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id_recibo", length = 8, nullable = false)
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
    private String tipoMoneda;
	
	@Column(name="T_Tipo_Servicio", length = 50, nullable = false)
    private String tipoServicio;
	
	@Column(name="T_Observacion", length = 8, nullable = false)
    private String observacion;

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

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	
	
	
}
