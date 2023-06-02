package com.bolivar.commons.actualizarTarifa.services;

import com.bolivar.commons.actualizarTarifa.models.ActualizarTarifaRequest;
import com.bolivar.commons.actualizarTarifa.models.ActualizarTarifaResponse;
import com.bolivar.commons.actualizarTarifa.repository.VistaTarifaEstandarRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarTarifaImpl implements ActualizarTarifaService {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private VistaTarifaEstandarRepository vistaTarifaEstandarRepository;

    /**
     * Constructor method for object instantiation
     */
    public ActualizarTarifaImpl(VistaTarifaEstandarRepository vistaTarifaEstandarRepository) {
        this.vistaTarifaEstandarRepository = vistaTarifaEstandarRepository;
    }

    @Override
    public ActualizarTarifaResponse getTotalFee(ActualizarTarifaRequest actualizarTarifaRequest) {
        return ActualizarTarifaResponse.builder().result("Resultado").build();
    }
}
