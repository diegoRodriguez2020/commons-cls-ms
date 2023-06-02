package com.bolivar.commons.obtenertarifabasica.controller;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import com.bolivar.commons.obtenertarifabasica.models.ObtenerTarifaBasicaRequest;
import com.bolivar.commons.obtenertarifabasica.services.ObtenerTarifaBasicaService;
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
            @RequestParam String ramoCodigoSiab,
            @RequestParam String productoCodigoSiab,
            @RequestParam Integer causaCodigoSiab,
            @RequestParam Integer originDestinationId,
            @RequestParam Integer codigoSiab,
            @RequestParam Integer totalKms) {
        ObtenerTarifaBasicaRequest request=ObtenerTarifaBasicaRequest.builder()
                .ramoCodigoSiab(ramoCodigoSiab)
                .productoCodigoSiab(productoCodigoSiab)
                .causaCodigoSiab(causaCodigoSiab)
                .originDestinationId(originDestinationId)
                .ciudadCodigoSiab(codigoSiab)
                .totalKms(totalKms).build();
        return obtenerTarifaBasicaService.getBasicFee(request);
    }
}
