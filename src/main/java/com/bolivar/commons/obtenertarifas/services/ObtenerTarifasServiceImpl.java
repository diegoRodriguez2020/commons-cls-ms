package com.bolivar.commons.obtenertarifas.services;

import com.bolivar.commons.commons.repositories.GetTariffsRepositoryImpl;
import com.bolivar.commons.obtenertarifas.dao.GetTariffDao;
import com.bolivar.commons.obtenertarifas.dao.ObtenerTarifasDao;
import com.bolivar.commons.commons.repositories.LogisticaTariffsRepository;
import com.bolivar.commons.obtenertarifas.models.ObtenerTarifasRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerTarifasServiceImpl implements ObtenerTarifasService {


    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("AlmacenarArchivosAWSS3ServiceImpl");

    private LogisticaTariffsRepository logisticaTariffsRepository;

    private GetTariffsRepositoryImpl getTariffsRepository;

    /**
     * Constructor method for object instantiation
     */
    public ObtenerTarifasServiceImpl(LogisticaTariffsRepository logisticaTariffsRepository, GetTariffsRepositoryImpl getTariffsRepository) {
        this.logisticaTariffsRepository = logisticaTariffsRepository;
        this.getTariffsRepository= getTariffsRepository;
    }

    /**
     * @see ObtenerTarifasService#obtenerListadoTarifas(ObtenerTarifasRequest)
     */
    @Override
    public List<ObtenerTarifasDao> obtenerListadoTarifas(ObtenerTarifasRequest requestModel) {
        return logisticaTariffsRepository.findAll();
    }

    @Override
    public List<GetTariffDao> obtenerVista(ObtenerTarifasRequest requestModel) {
        return getTariffsRepository.findTariff(requestModel.getRamoCodigoSiab(), requestModel.getProductoCodigoSiab(), requestModel.getCausaCodigoSiab(),requestModel.getOriginDestinationId(),requestModel.getCodigoSiab());
    }
}
