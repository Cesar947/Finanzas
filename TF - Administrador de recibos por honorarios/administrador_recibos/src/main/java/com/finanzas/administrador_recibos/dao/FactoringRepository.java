package com.finanzas.administrador_recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finanzas.administrador_recibos.model.Factoring;

@Repository
public interface FactoringRepository extends JpaRepository <Factoring, Integer> {
	@Query("select count(f.porcentajeDesgravamen) from Factoring f where f.porcentajeDesgravamen =:porcentajeDesgravamen")
	public int buscarDesgravamenFactoring(Integer porcentajeDesgravamen);
	
	@Query("select count(f.montoPortes) from Factoring f where f.montoPortes =:montoPortes")
	public int buscarmontoPortesFactoring(Integer montoPortes);
	
	@Query("select count(f.montoITF) from Factoring f where f.montoITF =:montoITF")
	public int buscarmontoITFFactoring(Integer montoITF);
	
	@Query("select count(f.montoTotalRecibido) from Factoring f where f.montoTotalRecibido =:montoTotalRecibido")
	public int buscarmontoTotalRecibidoFactoring(Integer montoTotalRecibido);
	
	@Query("select count(f.tceaTotal) from Factoring f where f.tceaTotal =:tceaTotal")
	public int buscartceaTotalFactoring(Integer tceaTotal);
	
	@Query("select count(f.fechaDescuento) from Factoring f where f.fechaDescuento =:fechaDescuento")
	public int buscarfechaDescuentoFactoring(Integer fechaDescuento);
	
}
