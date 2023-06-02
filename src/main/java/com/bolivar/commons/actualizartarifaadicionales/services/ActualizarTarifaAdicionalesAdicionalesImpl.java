package com.bolivar.commons.actualizartarifaadicionales.services;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesRequest;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesResponse;
import com.bolivar.commons.actualizartarifaadicionales.repository.AdicionalesEstandarRepository;
import com.bolivar.commons.actualizartarifaadicionales.repository.AdicionalesOperativosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Service
public class ActualizarTarifaAdicionalesAdicionalesImpl implements ActualizarTarifaAdicionalesService {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private AdicionalesEstandarRepository adicionalesEstandarRepository;

    private AdicionalesOperativosRepository adicionalesOperativosRepository;

    /**
     * Constructor method for object instantiation
     */
    public ActualizarTarifaAdicionalesAdicionalesImpl(AdicionalesEstandarRepository adicionalesEstandarRepository, AdicionalesOperativosRepository adicionalesOperativosRepository) {
        this.adicionalesEstandarRepository = adicionalesEstandarRepository;
        this.adicionalesOperativosRepository = adicionalesOperativosRepository;
    }

    @Override
    public ActualizarTarifaAdicionalesResponse getTotalFee(ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        for (TarifaAdicional standard: actualizarTarifaAdicionalesRequest.getStandardAdditional()) {
            standard.setValue(adicionalesEstandarRepository.getPrice(standard.getCode()).getPrice());
        }
        for (TarifaAdicional operative: actualizarTarifaAdicionalesRequest.getOperativeAdditional()) {
            operative.setValue(adicionalesOperativosRepository.getPrice(operative.getCode()).getPrice());
        }
        log.log(Level.INFO, "consulta de valor de adicionales estándar y operativos {0}", new Object[]{actualizarTarifaAdicionalesRequest.toString()});
        return ActualizarTarifaAdicionalesResponse.builder().build();
    }
}
