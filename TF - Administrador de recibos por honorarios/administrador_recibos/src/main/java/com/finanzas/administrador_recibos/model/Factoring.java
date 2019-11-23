package com.finanzas.administrador_recibos.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
    private double porcentajeDesgravamen;
    
    //DEBEMOS IGUALAR CON IF'S
    @Column(name = "M_Portes", length = 7, nullable = false)
    private double montoPortes;
    
    @Column(name = "M_ITF", length = 7, nullable = false)
    private double montoITF;
    
    //SE CALCULA CON FUNCIONES
   
    //SE INGRESA
    @ManyToOne 
    @JoinColumn(name="id_Tipo_Tasa", nullable = false)
    private TipoTasa tipoTasa;
    
    @ManyToOne
    @JoinColumn(name = "id_Capitalizacion", nullable = true)
    private Capitalizacion capitalizacion;
    
    //SE INGRESA
    @Column(name = "P_Tasa_Factoring", nullable = false)
    private double porcentajeTasaFactoring;

    
	 @Column(name = "D_Descuento", length = 40, nullable = false)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date fechaDescuento; 
	    
	 
	 @Column(name="T_Tipo_Moneda",length = 8, nullable = false)
	 private String tipoMoneda;
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPorcentajeDesgravamen() {
		return porcentajeDesgravamen;
	}

	public void setPorcentajeDesgravamen(double porcentajeDesgravamen) {
		this.porcentajeDesgravamen = porcentajeDesgravamen;
	}

	
	public double getMontoPortes() {
		return montoPortes;
	}

	public void setMontoPortes(double montoPortes) {
		this.montoPortes = montoPortes;
	}

	public double getMontoITF() {
		return montoITF;
	}

	public void setMontoITF(double montoITF) {
		this.montoITF = montoITF;
	}

	public Capitalizacion getCapitalizacion() {
		return capitalizacion;
	}

	public void setCapitalizacion(Capitalizacion capitalizacion) {
		this.capitalizacion = capitalizacion;
	}

	public void setPorcentajeTasaFactoring(double porcentajeTasaFactoring) {
		this.porcentajeTasaFactoring = porcentajeTasaFactoring;
	}

	public TipoTasa getTipoTasa() {
		return tipoTasa;
	}

	public void setTipoTasa(TipoTasa tipoTasa) {
		this.tipoTasa = tipoTasa;
	}

	public double getPorcentajeTasaFactoring() {
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
