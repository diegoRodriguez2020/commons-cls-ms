package com.bolivar.commons.actualizarTarifa.controller;

import com.bolivar.commons.actualizarTarifa.models.ActualizarTarifaRequest;
import com.bolivar.commons.actualizarTarifa.models.ActualizarTarifaResponse;
import com.bolivar.commons.actualizarTarifa.services.ActualizarTarifaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ActualizarTarifaController {
    private ActualizarTarifaService actualizarTarifaService;

    /**
     * Constructor method for object instantiation
     */
    public ActualizarTarifaController(ActualizarTarifaService actualizarTarifaService) {
        this.actualizarTarifaService = actualizarTarifaService;
    }
    @PostMapping(path = "/actualizartarifa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ActualizarTarifaResponse getStandardView(
            @Valid @RequestBody ActualizarTarifaRequest actualizarTarifaRequest) {
        return actualizarTarifaService.getTotalFee(actualizarTarifaRequest);
    }
}
