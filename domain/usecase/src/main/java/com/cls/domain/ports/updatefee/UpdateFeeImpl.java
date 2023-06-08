package com.cls.domain.ports.updatefee;


import com.cls.domain.ports.updatefee.in.UpdateFee;
import com.cls.domain.ports.updatefee.out.AdditionalStandardsRepository;
import com.cls.domain.ports.updatefee.out.AddtionalOperationsRepository;
import com.cls.domain.ports.commons.utilities.FeeCalculator;
import com.cls.model.dao.commons.AdditionalStandardsDao;
import com.cls.model.dao.commons.AdditionalOperationsDao;
import com.cls.model.request.updatefee.ActualizarTarifaAdicionalesRequest;
import com.cls.model.response.updatefee.ActualizarTarifaAdicionalesResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

@Service
public class UpdateFeeImpl implements UpdateFee {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("ObtenerTarifaEstandarImpl");
    private AdditionalStandardsRepository additionalStandardsRepository;

    private AddtionalOperationsRepository addtionalOperationsRepository;

    private FeeCalculator feeCalculator;

    /**
     * Constructor method for object instantiation
     */
    public UpdateFeeImpl(AdditionalStandardsRepository additionalStandardsRepository, AddtionalOperationsRepository addtionalOperationsRepository, FeeCalculator feeCalculator) {
        this.additionalStandardsRepository = additionalStandardsRepository;
        this.addtionalOperationsRepository = addtionalOperationsRepository;
        this.feeCalculator = feeCalculator;
    }

    @Override
    public ActualizarTarifaAdicionalesResponse getTotalFee(ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        ActualizarTarifaAdicionalesResponse response= new ActualizarTarifaAdicionalesResponse();
        int baseFee=0;
        response.setBaseFee(baseFee);
        List<AdditionalStandardsDao> additionalStandardsDao = additionalStandardsRepository.findStandardsList(actualizarTarifaAdicionalesRequest.getStandardAdditional());
        List<AdditionalOperationsDao> additionalOperationsDao = addtionalOperationsRepository.findOperationsList(actualizarTarifaAdicionalesRequest.getOperativeAdditional());
        //No deberíamos usar Integer sino Long, Double, BigDecimal
        //cambiar TarifaAdicional."code" por "id"
        int standardFee= feeCalculator.calculateTotalAdditionalStandardsFee(actualizarTarifaAdicionalesRequest.getStandardAdditional(), additionalStandardsDao);
        int operativeFee= feeCalculator.calculateTotalAdditionalOperationsFee(actualizarTarifaAdicionalesRequest.getOperativeAdditional(), additionalOperationsDao);
        response.setStandardFee(standardFee);
        response.setOperativeFee(operativeFee);
        response.setTotalFee(feeCalculator.calculateTotalFee(baseFee,standardFee, operativeFee));
        log.log(Level.INFO, "response: {0}", new Object[]{response.toString()});
        return response;
    }
}
