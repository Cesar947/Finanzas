package com.finanzas.administrador_recibos.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "Detalle_Factoring")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactoring implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Detalle", length = 7, nullable = false)
    private Integer id;
	
    @ManyToOne 
    @JoinColumn(name="id_Factoring")
    private Factoring factoring;
	
    @ManyToOne 
    @JoinColumn(name="id_Codigo")
    private ReciboHonorarios reciboHonorarios;

    @Column(name = "TCEA", length = 7, nullable = false)
    private BigDecimal tcea; 
    
    @Column(name = "M_Valor_Recibido", length = 7, nullable = false)
    private BigDecimal montoValorRecibido; 

    @Column(name = "M_Valor_Entregado", length = 7, nullable = false)
    private BigDecimal montoValorEntregado;

    @Column(name = "M_Descontado", length = 7, nullable = false)
    private BigDecimal montoDescontado;

    @Column(name = "P_Tasa_Descontada", length = 7, nullable = false)
    private BigDecimal porcentajeTasaDescontada;

    @Column(name = "M_Valor_Neto", length = 7, nullable = false)
    private int montoValorNeto;

    @Column(name = "N_Periodo_Dias", length = 7, nullable = false)
    private int numeroPeriodoDias;
    
    
}
