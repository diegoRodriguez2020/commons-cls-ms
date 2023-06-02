package com.bolivar.commons.obtenertarifaestandar.services;

import com.bolivar.commons.obtenertarifaestandar.dao.ObtenerTarifaEstandarDao;
import com.bolivar.commons.obtenertarifaestandar.models.ObtenerTarifaEstandarRequest;
import com.bolivar.commons.obtenertarifaestandar.repository.VistaTarifaEstandarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerTarifaEstandarImpl implements ObtenerTarifaEstandarService {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private VistaTarifaEstandarRepository vistaTarifaEstandarRepository;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifaEstandarImpl(VistaTarifaEstandarRepository vistaTarifaEstandarRepository) {
        this.vistaTarifaEstandarRepository = vistaTarifaEstandarRepository;
    }

    @Override
    public List<ObtenerTarifaEstandarDao> getStandardFee(ObtenerTarifaEstandarRequest obtenerTarifaEstandarRequest) {
        return vistaTarifaEstandarRepository.findStandardFee(obtenerTarifaEstandarRequest.getRamoCodigoSiab(), obtenerTarifaEstandarRequest.getProductoCodigoSiab(), obtenerTarifaEstandarRequest.getCausaCodigoSiab(), obtenerTarifaEstandarRequest.getOriginDestinationId(), obtenerTarifaEstandarRequest.getCiudadCodigoSiab());
    }
}
