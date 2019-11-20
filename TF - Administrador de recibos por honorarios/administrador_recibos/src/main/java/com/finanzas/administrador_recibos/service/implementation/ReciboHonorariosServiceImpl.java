package com.finanzas.administrador_recibos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.administrador_recibos.dao.ReciboHonorariosRepository;
import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.service.ReciboHonorariosService;

@Service
public class ReciboHonorariosServiceImpl implements ReciboHonorariosService {
	
	private ReciboHonorariosRepository reciboHonorariosRepository;
	
    @Autowired
    public ReciboHonorariosServiceImpl(ReciboHonorariosRepository reciboHonorariosRepository) {
        this.reciboHonorariosRepository = reciboHonorariosRepository;
    }

    public ReciboHonorarios registrarReciboPorHonorarios(ReciboHonorarios recibo) throws Exception{

        return reciboHonorariosRepository.save(recibo);
    }
	
	
	public ReciboHonorarios EncontrarPorID(String reciboId) {
		return reciboHonorariosRepository.findById(reciboId).get();
	}

	@Override
	public List<ReciboHonorarios> listarTodo() {
		// TODO Auto-generated method stub
		return reciboHonorariosRepository.findAll();
	}

}
