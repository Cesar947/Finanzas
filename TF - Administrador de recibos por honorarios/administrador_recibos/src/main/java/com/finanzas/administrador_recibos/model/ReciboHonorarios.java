package com.finanzas.administrador_recibos.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name="D_Emision",length = 40, nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "La fecha es obligatoria")
    @Future(message = "La fecha debe estar en el futuro")
    @Column(name="D_Vencimiento",length = 40, nullable = false)
    private Date fechaVencimiento;
	
	@Column(name="M_Honorarios", length = 15, nullable = false)
    private double montoHonorarios;
	
	@Column(name="M_Retencion_IR", length = 40, nullable = false)
    private double retencionIR;
	
	@Column(name="M_Honorarios_Neto", length = 15, nullable = false)
    private double montoNeto;
	
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
	
	@Column(name="T_Observacion", length = 40, nullable = false)
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

	public double getMontoHonorarios() {
		return montoHonorarios;
	}

	public void setMontoHonorarios(double montoHonorarios) {
		this.montoHonorarios = montoHonorarios;
	}

	public double getRetencionIR() {
		return retencionIR;
	}

	public void setRetencionIR(double retencionIR) {
		this.retencionIR = retencionIR;
	}

	public double getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(double montoNeto) {
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
