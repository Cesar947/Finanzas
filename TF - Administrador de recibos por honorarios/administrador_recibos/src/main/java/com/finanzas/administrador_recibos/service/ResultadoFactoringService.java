package com.finanzas.administrador_recibos.service;

import java.util.List;

import com.finanzas.administrador_recibos.model.ReciboHonorarios;
import com.finanzas.administrador_recibos.model.ResultadoFactoring;
import com.finanzas.administrador_recibos.model.ResultadoModelo;


public interface ResultadoFactoringService {
      
      
      public ResultadoFactoring CalcularResultado(List<ReciboHonorarios> recibos, Integer factId);
 
      public ResultadoModelo mostrarCalculos(Integer factId);
}
