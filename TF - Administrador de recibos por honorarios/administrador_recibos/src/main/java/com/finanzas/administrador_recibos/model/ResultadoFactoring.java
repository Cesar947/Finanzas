package com.finanzas.administrador_recibos.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resultado_factoring")
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoFactoring {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Resultado_factoring", length = 7, nullable = false)
    private Integer id;
	
	 @Column(name = "M_Recibido_Total", length = 7, nullable = false)
	    private double montoTotalRecibido;
	    
	 @Column(name = "TCEA_Total",  nullable = true)
	 private double tceaTotal;
	   
	 @OneToOne
	 @JoinColumn(name="id_Factoring")
	 private Factoring factoring;

	public Factoring getFactoring() {
		return factoring;
	}

	public void setFactoring(Factoring factoring) {
		this.factoring = factoring;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMontoTotalRecibido() {
		return montoTotalRecibido;
	}

	public void setMontoTotalRecibido(double montoTotalRecibido) {
		this.montoTotalRecibido = montoTotalRecibido;
	}

	public double getTceaTotal() {
		return tceaTotal;
	}

	public void setTceaTotal(double tceaTotal) {
		this.tceaTotal = tceaTotal;
	}
	
	 
	 
	 
}
