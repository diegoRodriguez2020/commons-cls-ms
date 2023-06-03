package com.bolivar.commons.actualizartarifaadicionales.services;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesRequest;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesResponse;
import com.bolivar.commons.actualizartarifaadicionales.repository.AdicionalesEstandarRepository;
import com.bolivar.commons.actualizartarifaadicionales.repository.AdicionalesOperativosRepository;
import com.bolivar.commons.actualizartarifaadicionales.utils.Utilities;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Level;

@Service
public class ActualizarTarifaAdicionalesAdicionalesImpl implements ActualizarTarifaAdicionalesService {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private AdicionalesEstandarRepository adicionalesEstandarRepository;

    private AdicionalesOperativosRepository adicionalesOperativosRepository;

    private Utilities utilities;

    /**
     * Constructor method for object instantiation
     */
    public ActualizarTarifaAdicionalesAdicionalesImpl(AdicionalesEstandarRepository adicionalesEstandarRepository, AdicionalesOperativosRepository adicionalesOperativosRepository, Utilities utilities) {
        this.adicionalesEstandarRepository = adicionalesEstandarRepository;
        this.adicionalesOperativosRepository = adicionalesOperativosRepository;
        this.utilities = utilities;
    }

    @Override
    public ActualizarTarifaAdicionalesResponse getTotalFee(ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        ActualizarTarifaAdicionalesResponse response= new ActualizarTarifaAdicionalesResponse();
        actualizarTarifaAdicionalesRequest.getStandardAdditional().sort(Comparator.comparing(TarifaAdicional::getCode));
        actualizarTarifaAdicionalesRequest.getOperativeAdditional().sort(Comparator.comparing(TarifaAdicional::getCode));
        List<AdicionalEstandarDao> adicionalEstandarDao = adicionalesEstandarRepository.getPrice(actualizarTarifaAdicionalesRequest.getStandardAdditional());
        List<AdicionalOperativoDao> adicionalOperativoDao = adicionalesOperativosRepository.getPrice(actualizarTarifaAdicionalesRequest.getOperativeAdditional());
        //Riesgo de que al realizar las consultas los datos lleguen en un orden diferente al solicitado.
        //Riesgo de que al ordenar se altere el orden de los precios.
        //Tal vez deberíamos devolver en el response datos de los precios.
        //cambiar TarifaAdicional."code" por "id"
        int standardFee=utilities.calculateAdditionalStandard(actualizarTarifaAdicionalesRequest.getStandardAdditional(), adicionalEstandarDao);
        int operativeFee=utilities.calculateAdditionalOperative(actualizarTarifaAdicionalesRequest.getOperativeAdditional(), adicionalOperativoDao);
        response.setStandardFee(standardFee);
        response.setOperativeFee(operativeFee);
        response.setTotalFee(utilities.calculateTotalFee(standardFee, operativeFee));

        log.log(Level.INFO, "response: {0}", new Object[]{response.toString()});
        return response;
    }
}
