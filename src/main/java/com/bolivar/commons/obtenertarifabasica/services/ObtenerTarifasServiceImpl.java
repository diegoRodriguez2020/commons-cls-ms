package com.bolivar.commons.obtenertarifabasica.services;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
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
    public List<ObtenerTarifaBasicaDao> getBasicFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiab) {
        return vistaTarifaRepository.findBasicFee(ramoCodigoSiab, productoCodigoSiab, causaCodigoSiab, originDestinationId, codigoSiab);
    }
}
