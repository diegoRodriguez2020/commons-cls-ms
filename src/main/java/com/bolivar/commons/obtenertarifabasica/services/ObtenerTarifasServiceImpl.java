package com.bolivar.commons.obtenertarifabasica.services;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import com.bolivar.commons.obtenertarifabasica.models.ObtenerTarifaBasicaRequest;
import com.bolivar.commons.obtenertarifabasica.repository.VistaTarifaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerTarifasServiceImpl implements ObtenerTarifaBasicaService {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifasServiceImpl");
    private VistaTarifaRepository vistaTarifaRepository;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifasServiceImpl(VistaTarifaRepository vistaTarifaRepository) {
        this.vistaTarifaRepository = vistaTarifaRepository;
    }

    @Override
    public List<ObtenerTarifaBasicaDao> getBasicFee(ObtenerTarifaBasicaRequest obtenerTarifaBasicaRequest) {
        List<ObtenerTarifaBasicaDao> tarifaBasica = getTarifaBasica(obtenerTarifaBasicaRequest);
        adjustTotalTarifaBase(tarifaBasica, obtenerTarifaBasicaRequest.getTotalKms());
        return tarifaBasica;
    }

    private List<ObtenerTarifaBasicaDao> getTarifaBasica(ObtenerTarifaBasicaRequest obtenerTarifaBasicaRequest) {
        return vistaTarifaRepository.findBasicFee(
                obtenerTarifaBasicaRequest.getRamoCodigoSiab(),
                obtenerTarifaBasicaRequest.getProductoCodigoSiab(),
                obtenerTarifaBasicaRequest.getCausaCodigoSiab(),
                obtenerTarifaBasicaRequest.getOriginDestinationId(),
                obtenerTarifaBasicaRequest.getCiudadCodigoSiab()
        );
    }

    private void adjustTotalTarifaBase(List<ObtenerTarifaBasicaDao> tarifaBasica, Integer totalKms) {
        if (totalKms != null && totalKms > 0 && !tarifaBasica.isEmpty()) {
            ObtenerTarifaBasicaDao firstTarifa = tarifaBasica.get(0);
            Integer totalTarifaBase = firstTarifa.getFeePrice() + (firstTarifa.getFeePriceXKm() * totalKms);
            firstTarifa.setFeePrice(totalTarifaBase);
        }
    }
}
