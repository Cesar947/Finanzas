package com.finanzas.administrador_recibos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "Factoring")
@NoArgsConstructor
@AllArgsConstructor
public class Factoring implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Factoring", length = 7, nullable = false)
    private Integer id;
	
    @Column(name = "P_Desgravamen", length = 7, nullable = false)
    private Integer porcentajeDesgravamen;
    
    @Column(name = "M_Portes", length = 7, nullable = false)
    private Integer montoPortes;
    
    @Column(name = "M_ITF", length = 7, nullable = false)
    private Integer montoITF;
    
    @Column(name = "M_Recibido_Total", length = 7, nullable = false)
    private BigDecimal montoTotalRecibido;
    
    @Column(name = "TCEA_Total", length = 7, nullable = true)
    private BigDecimal tceaTotal;
    
    @Column(name = "D_Descuento", length = 7, nullable = false)
    private Date fechaDescuento; 
    
    @ManyToOne 
    @JoinColumn(name="id_Tipo_Tasa")
    private TipoTasa tipoTasa;
    
    @ManyToOne
    @JoinColumn(name = "id_Capitalizacion", nullable = true)
    private Capitalizacion capitalizacion;
    
    @Column(name = "P_Tasa_Factoring", length = 7, nullable = false)
    private Date porcentajeTasaFactoring;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPorcentajeDesgravamen() {
		return porcentajeDesgravamen;
	}

	public void setPorcentajeDesgravamen(Integer porcentajeDesgravamen) {
		this.porcentajeDesgravamen = porcentajeDesgravamen;
	}

	public Integer getMontoPortes() {
		return montoPortes;
	}

	public void setMontoPortes(Integer montoPortes) {
		this.montoPortes = montoPortes;
	}

	public Integer getMontoITF() {
		return montoITF;
	}

	public void setMontoITF(Integer montoITF) {
		this.montoITF = montoITF;
	}

	public BigDecimal getMontoTotalRecibido() {
		return montoTotalRecibido;
	}

	public void setMontoTotalRecibido(BigDecimal montoTotalRecibido) {
		this.montoTotalRecibido = montoTotalRecibido;
	}

	public BigDecimal getTceaTotal() {
		return tceaTotal;
	}

	public void setTceaTotal(BigDecimal tceaTotal) {
		this.tceaTotal = tceaTotal;
	}

	public Date getFechaDescuento() {
		return fechaDescuento;
	}

	public void setFechaDescuento(Date fechaDescuento) {
		this.fechaDescuento = fechaDescuento;
	}

	public TipoTasa getTipoTasa() {
		return tipoTasa;
	}

	public void setTipoTasa(TipoTasa tipoTasa) {
		this.tipoTasa = tipoTasa;
	}

	public Date getPorcentajeTasaFactoring() {
		return porcentajeTasaFactoring;
	}

	public void setPorcentajeTasaFactoring(Date porcentajeTasaFactoring) {
		this.porcentajeTasaFactoring = porcentajeTasaFactoring;
	} 	

    
}
