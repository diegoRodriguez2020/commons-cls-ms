package com.cls.domain.ports.updatefee;


import com.cls.domain.ports.updatefee.in.UpdateFee;
import com.cls.domain.ports.updatefee.out.AdicionalesEstandarRepository;
import com.cls.domain.ports.updatefee.out.AdicionalesOperativosRepository;
import com.cls.domain.utilities.commons.Utilities;
import com.cls.model.dao.updatefee.AdicionalEstandarDao;
import com.cls.model.dao.updatefee.AdicionalOperativoDao;
import com.cls.model.request.updatefee.ActualizarTarifaAdicionalesRequest;
import com.cls.model.response.updatefee.ActualizarTarifaAdicionalesResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

@Service
public class UpdateFeeImpl implements UpdateFee {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private AdicionalesEstandarRepository adicionalesEstandarRepository;

    private AdicionalesOperativosRepository adicionalesOperativosRepository;

    private Utilities utilities;

    /**
     * Constructor method for object instantiation
     */
    public UpdateFeeImpl(AdicionalesEstandarRepository adicionalesEstandarRepository, AdicionalesOperativosRepository adicionalesOperativosRepository, Utilities utilities) {
        this.adicionalesEstandarRepository = adicionalesEstandarRepository;
        this.adicionalesOperativosRepository = adicionalesOperativosRepository;
        this.utilities = utilities;
    }

    @Override
    public ActualizarTarifaAdicionalesResponse getTotalFee(ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        ActualizarTarifaAdicionalesResponse response= new ActualizarTarifaAdicionalesResponse();
        int baseFee=0;
        response.setBaseFee(baseFee);
        List<AdicionalEstandarDao> adicionalEstandarDao = adicionalesEstandarRepository.getPrice(actualizarTarifaAdicionalesRequest.getStandardAdditional());
        List<AdicionalOperativoDao> adicionalOperativoDao = adicionalesOperativosRepository.getPrice(actualizarTarifaAdicionalesRequest.getOperativeAdditional());
        //No deberíamos usar Integer sino Long, Double, BigDecimal
        //cambiar TarifaAdicional."code" por "id"
        int standardFee=utilities.calculateAdditionalStandard(actualizarTarifaAdicionalesRequest.getStandardAdditional(), adicionalEstandarDao);
        int operativeFee=utilities.calculateAdditionalOperative(actualizarTarifaAdicionalesRequest.getOperativeAdditional(), adicionalOperativoDao);
        response.setStandardFee(standardFee);
        response.setOperativeFee(operativeFee);
        response.setTotalFee(utilities.calculateTotalFee(baseFee,standardFee, operativeFee));
        log.log(Level.INFO, "response: {0}", new Object[]{response.toString()});
        return response;
    }
}
