package com.bolivar.commons.actualizartarifaadicionales.controller;

import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesRequest;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesResponse;
import com.bolivar.commons.actualizartarifaadicionales.services.ActualizarTarifaAdicionalesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ActualizarTarifaAdicionalesController {
    private ActualizarTarifaAdicionalesService actualizarTarifaAdicionalesService;

    /**
     * Constructor method for object instantiation
     */
    public ActualizarTarifaAdicionalesController(ActualizarTarifaAdicionalesService actualizarTarifaAdicionalesService) {
        this.actualizarTarifaAdicionalesService = actualizarTarifaAdicionalesService;
    }
    @PostMapping(path = "/actualizartarifa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ActualizarTarifaAdicionalesResponse getStandardView(
            @Valid @RequestBody ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        return actualizarTarifaAdicionalesService.getTotalFee(actualizarTarifaAdicionalesRequest);
    }
}
