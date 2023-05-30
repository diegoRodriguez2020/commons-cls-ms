package com.bolivar.commons.obtenerresultado.controller;

import com.bolivar.commons.obtenerresultado.models.ObtenerResultadoRequest;
import com.bolivar.commons.obtenerresultado.services.ObtenerResultadoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <h3>Controlador REST para almacenamiento de un archivo en AWS S3</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodríguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
@RestController
@RequestMapping("/api/v1/health")
public class ObtenerResultadoController {
    /**
     * <h2>almacenarArchivoS3Service</h2>
     * almacenarArchivoS3Service type AlmacenarArchivoS3Service
     */
    private ObtenerResultadoService obtenerResultadoService;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerResultadoController(ObtenerResultadoService obtenerResultadoService) {
        this.obtenerResultadoService = obtenerResultadoService;
    }

    /**
     * Parameter validation method
     *
     * @param folder String with folder
     * @return a Response entity with the response of service
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String obtener(@RequestBody ObtenerResultadoRequest obtenerResultadoRequest){
        return obtenerResultadoService.obtenerRespuesta(obtenerResultadoRequest);
    }
}
