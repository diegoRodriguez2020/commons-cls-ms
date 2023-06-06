package com.adapter.api.v1;

import com.domain.ports.in.ViewFeesManagement;
import com.model.dao.ObtenerTarifaBasicaDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ObtenerTarifaBasica {
    private ViewFeesManagement viewFeesManagement;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifaBasica(ViewFeesManagement viewFeesManagement) {
        this.viewFeesManagement = viewFeesManagement;
    }

    @GetMapping(path = "/tarifabasicas")
    public List<ObtenerTarifaBasicaDao> getFeeView(
            @RequestParam String ramoCodigoSiab,
            @RequestParam String productoCodigoSiab,
            @RequestParam Integer causaCodigoSiab,
            @RequestParam Integer originDestinationId,
            @RequestParam Integer codigoSiab,
            @RequestParam Integer totalKms) {
        /*ObtenerTarifaBasicaRequest request=ObtenerTarifaBasicaRequest.builder()
                .ramoCodigoSiab(ramoCodigoSiab)
                .productoCodigoSiab(productoCodigoSiab)
                .causaCodigoSiab(causaCodigoSiab)
                .originDestinationId(originDestinationId)
                .ciudadCodigoSiab(codigoSiab)
                .totalKms(totalKms).build();*/
        return viewFeesManagement.getFee(ramoCodigoSiab, productoCodigoSiab, causaCodigoSiab, originDestinationId, codigoSiab, totalKms);
    }
}
