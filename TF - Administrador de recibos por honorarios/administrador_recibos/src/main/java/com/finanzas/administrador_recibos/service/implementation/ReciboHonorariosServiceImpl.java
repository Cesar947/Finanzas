package com.finanzas.administrador_recibos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.administrador_recibos.dao.ClienteRepository;
import com.finanzas.administrador_recibos.dao.EmisorRepository;
import com.finanzas.administrador_recibos.dao.ReciboHonorariosRepository;
import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.service.ReciboHonorariosService;

@Service
public class ReciboHonorariosServiceImpl implements ReciboHonorariosService {
	
	private ReciboHonorariosRepository reciboHonorariosRepository;
	private EmisorRepository emisorRepository;
	private ClienteRepository clienteRepository;
	
    @Autowired
    public ReciboHonorariosServiceImpl(ReciboHonorariosRepository reciboHonorariosRepository
    		, EmisorRepository emisorRepository, ClienteRepository clienteRepository ) {
        this.reciboHonorariosRepository = reciboHonorariosRepository;
        this.emisorRepository = emisorRepository;
        this.clienteRepository = clienteRepository;
    }

    public ReciboHonorarios registrarReciboPorHonorarios(ReciboHonorarios recibo, Integer emisorId
    		, Integer clienteId) throws Exception{

    	recibo.setEmisor(emisorRepository.findById(emisorId).get());
    	recibo.setCliente(clienteRepository.findById(clienteId).get());
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
