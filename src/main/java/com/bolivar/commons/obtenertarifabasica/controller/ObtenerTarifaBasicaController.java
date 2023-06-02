package com.bolivar.commons.obtenertarifabasica.controller;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import com.bolivar.commons.obtenertarifabasica.models.ObtenerTarifaBasicaRequest;
import com.bolivar.commons.obtenertarifabasica.services.ObtenerTarifaBasicaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ObtenerTarifaBasicaController {
    private ObtenerTarifaBasicaService obtenerTarifaBasicaService;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifaBasicaController(ObtenerTarifaBasicaService obtenerTarifaBasicaService) {
        this.obtenerTarifaBasicaService = obtenerTarifaBasicaService;
    }
    @GetMapping(path = "/tarifabasica")
    public List<ObtenerTarifaBasicaDao> getFeeView(
            ObtenerTarifaBasicaRequest obtenerTarifaBasicaRequest) {
        return obtenerTarifaBasicaService.getBasicFee(obtenerTarifaBasicaRequest);
    }
}
