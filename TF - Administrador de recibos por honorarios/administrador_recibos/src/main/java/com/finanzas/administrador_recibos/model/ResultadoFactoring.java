package com.finanzas.administrador_recibos.model;

import java.math.BigDecimal;

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
	    private BigDecimal montoTotalRecibido;
	    
	 @Column(name = "TCEA_Total", length = 7, nullable = true)
	 private BigDecimal tceaTotal;
	   
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
	
	 
	 
	 
}
