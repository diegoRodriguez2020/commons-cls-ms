package com.bolivar.commons.actualizartarifaadicionales.services;

import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesRequest;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesResponse;
import com.bolivar.commons.actualizartarifaadicionales.repository.VistaTarifaEstandarRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarTarifaAdicionalesAdicionalesImpl implements ActualizarTarifaAdicionalesService {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private VistaTarifaEstandarRepository vistaTarifaEstandarRepository;

    /**
     * Constructor method for object instantiation
     */
    public ActualizarTarifaAdicionalesAdicionalesImpl(VistaTarifaEstandarRepository vistaTarifaEstandarRepository) {
        this.vistaTarifaEstandarRepository = vistaTarifaEstandarRepository;
    }

    @Override
    public ActualizarTarifaAdicionalesResponse getTotalFee(ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        return ActualizarTarifaAdicionalesResponse.builder().result("Resultado").build();
    }
}
