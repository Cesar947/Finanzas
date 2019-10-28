package com.finanzas.administrador_recibos.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;

import com.finanzas.administrador_recibos.dao.TipoTasaRepository;
import com.finanzas.administrador_recibos.model.TipoTasa;
import com.finanzas.administrador_recibos.service.TipoTasaService;

public class TipoTasaServiceImpl implements TipoTasaService{

	private TipoTasaRepository tipoTasaRepository;
	
    @Autowired
    public TipoTasaServiceImpl(TipoTasaRepository tipoTasaRepository) {
        this.tipoTasaRepository = tipoTasaRepository;
    }

    public TipoTasa registrarTipoTasa(TipoTasa tipotasa) throws Exception{

        return tipoTasaRepository.save(tipotasa);
    }

	public TipoTasa EncontrarPorID(Integer tasaid) {
		return tipoTasaRepository.findById(tasaid).get();
	}

}
