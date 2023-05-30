package com.bolivar.commons.obtenertarifas.controller;

import com.bolivar.commons.obtenertarifas.dao.ObtenerTarifasDao;
import com.bolivar.commons.obtenertarifas.models.ObtenerTarifasRequest;
import com.bolivar.commons.obtenertarifas.services.ObtenerTarifasService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tariffs")
public class ObtenerTarifasController {
    private ObtenerTarifasService obtenerTarifasService;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifasController(ObtenerTarifasService obtenerTarifasService) {
        this.obtenerTarifasService = obtenerTarifasService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ObtenerTarifasDao> obtener(@RequestBody ObtenerTarifasRequest obtenerTarifasRequest){
        return obtenerTarifasService.obtenerListadoTarifas(obtenerTarifasRequest);
    }
}
