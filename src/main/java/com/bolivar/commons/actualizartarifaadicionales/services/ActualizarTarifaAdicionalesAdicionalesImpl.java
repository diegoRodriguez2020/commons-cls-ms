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
        List<AdicionalEstandarDao> adicionalEstandarDao = new ArrayList<>();
        for (TarifaAdicional adicional: actualizarTarifaAdicionalesRequest.getStandardAdditional()) {
            adicionalEstandarDao.add(adicionalesEstandarRepository.getPrice(adicional.getCode()));
        }

        List<AdicionalOperativoDao> adicionalOperativoDao = new ArrayList<>();
        for (TarifaAdicional adicional: actualizarTarifaAdicionalesRequest.getOperativeAdditional()) {
            adicionalOperativoDao.add(adicionalesOperativosRepository.getPrice(adicional.getCode()));
        }
        log.log(Level.INFO, "estándar {0} y operativo {1}", new Object[]{adicionalEstandarDao.toString(), adicionalOperativoDao.toString()});
        return ActualizarTarifaAdicionalesResponse.builder().build();
    }
}
