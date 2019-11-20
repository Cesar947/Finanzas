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
@Table(name = "Factoring")
@NoArgsConstructor
@AllArgsConstructor
public class Factoring implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//SE GENERA
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Factoring", length = 7, nullable = false)
    private Integer id;
	
	//SE INGRESA
    @Column(name = "P_Desgravamen", length = 7, nullable = false)
    private BigDecimal porcentajeDesgravamen;
    
    //DEBEMOS IGUALAR CON IF'S
    @Column(name = "M_Portes", length = 7, nullable = false)
    private BigDecimal montoPortes;
    
    @Column(name = "M_ITF", length = 7, nullable = false)
    private BigDecimal montoITF;
    
    //SE CALCULA CON FUNCIONES
   
    //SE INGRESA
    @ManyToOne 
    @JoinColumn(name="id_Tipo_Tasa")
    private TipoTasa tipoTasa;
    
    @ManyToOne
    @JoinColumn(name = "id_Capitalizacion", nullable = true)
    private Capitalizacion capitalizacion;
    
    //SE INGRESA
    @Column(name = "P_Tasa_Factoring", length = 7, nullable = false)
    private BigDecimal porcentajeTasaFactoring;

    
	 @Column(name = "D_Descuento", length = 7, nullable = false)
	 private Date fechaDescuento; 
	    
	 
	 @Column(name="T_Tipo_Moneda",length = 8, nullable = false)
	 private String tipoMoneda;
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPorcentajeDesgravamen() {
		return porcentajeDesgravamen;
	}

	public void setPorcentajeDesgravamen(BigDecimal porcentajeDesgravamen) {
		this.porcentajeDesgravamen = porcentajeDesgravamen;
	}

	
	public BigDecimal getMontoPortes() {
		return montoPortes;
	}

	public void setMontoPortes(BigDecimal montoPortes) {
		this.montoPortes = montoPortes;
	}

	public BigDecimal getMontoITF() {
		return montoITF;
	}

	public void setMontoITF(BigDecimal montoITF) {
		this.montoITF = montoITF;
	}

	public Capitalizacion getCapitalizacion() {
		return capitalizacion;
	}

	public void setCapitalizacion(Capitalizacion capitalizacion) {
		this.capitalizacion = capitalizacion;
	}

	public void setPorcentajeTasaFactoring(BigDecimal porcentajeTasaFactoring) {
		this.porcentajeTasaFactoring = porcentajeTasaFactoring;
	}

	public TipoTasa getTipoTasa() {
		return tipoTasa;
	}

	public void setTipoTasa(TipoTasa tipoTasa) {
		this.tipoTasa = tipoTasa;
	}

	public BigDecimal getPorcentajeTasaFactoring() {
		return porcentajeTasaFactoring;
	}

	public Date getFechaDescuento() {
		return fechaDescuento;
	}

	public void setFechaDescuento(Date fechaDescuento) {
		this.fechaDescuento = fechaDescuento;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	

    
}
