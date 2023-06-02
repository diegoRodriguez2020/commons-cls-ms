package com.bolivar.commons.obtenertarifaestandar.controller;

import com.bolivar.commons.obtenertarifaestandar.dao.ObtenerTarifaEstandarDao;
import com.bolivar.commons.obtenertarifaestandar.models.ObtenerTarifaEstandarRequest;
import com.bolivar.commons.obtenertarifaestandar.services.ObtenerTarifaEstandarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ObtenerTarifaEstandarController {
    private ObtenerTarifaEstandarService obtenerTarifaEstandarService;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifaEstandarController(ObtenerTarifaEstandarService obtenerTarifaEstandarService) {
        this.obtenerTarifaEstandarService = obtenerTarifaEstandarService;
    }
    @GetMapping(path = "/tarifaestandar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ObtenerTarifaEstandarDao> getStandardView(
            ObtenerTarifaEstandarRequest obtenerTarifaEstandarRequest) {
        return obtenerTarifaEstandarService.getStandardFee(obtenerTarifaEstandarRequest);
    }
}
