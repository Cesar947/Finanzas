package com.finanzas.administrador_recibos.model;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tipo_Tasa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factoring {
	
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
    
    @Column(name = "TCEA_Total", length = 7, nullable = false)
    private BigDecimal tceaTotal;
    
    @Column(name = "D_Descuento", length = 7, nullable = false)
    private Date fechaDescuento; 
    
    @ManyToOne 
    @JoinColumn(name="id_Tipo_Tasa")
    private TipoTasa tipotasa;
    
    @Column(name = "P_Tasa_Factoring", length = 7, nullable = false)
    private Date porcentajeTasaFactoring; 	

}
