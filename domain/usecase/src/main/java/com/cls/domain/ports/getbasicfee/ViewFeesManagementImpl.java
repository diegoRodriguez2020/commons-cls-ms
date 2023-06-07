package com.cls.domain.ports.getbasicfee;

import com.cls.domain.ports.getbasicfee.in.ViewFeesManagement;
import com.cls.domain.ports.getbasicfee.out.ViewFeesManagementRepository;
import com.cls.domain.ports.updatefee.in.UpdateFee;
import com.cls.domain.ports.updatefee.out.AdicionalesEstandarRepository;
import com.cls.domain.ports.updatefee.out.AdicionalesOperativosRepository;
import com.cls.domain.utilities.commons.Utilities;
import com.cls.model.dao.getbasicfee.BasicFeeDao;
import com.cls.model.dao.updatefee.AdicionalEstandarDao;
import com.cls.model.dao.updatefee.AdicionalOperativoDao;
import com.cls.model.request.getbasicfee.FeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ViewFeesManagementImpl implements ViewFeesManagement {
    private ViewFeesManagementRepository viewFeesManagementRepository;
    private AdicionalesEstandarRepository adicionalesEstandarRepository;
    private AdicionalesOperativosRepository adicionalesOperativosRepository;
    private Utilities utilities;


    public ViewFeesManagementImpl(ViewFeesManagementRepository viewFeesManagementRepository, Utilities utilities, AdicionalesEstandarRepository adicionalesEstandarRepository, AdicionalesOperativosRepository adicionalesOperativosRepository) {
        this.viewFeesManagementRepository = viewFeesManagementRepository;
        this.utilities = utilities;
        this.adicionalesEstandarRepository = adicionalesEstandarRepository;
        this.adicionalesOperativosRepository = adicionalesOperativosRepository;
    }

    @Override
    public List<BasicFeeDao> getFee(FeeRequest feeRequest) {
        List<BasicFeeDao> basicFeeDao = viewFeesManagementRepository.findBasicFee(feeRequest.getBasicFee().getRamoCodigoSiab(), feeRequest.getBasicFee().getProductoCodigoSiab(), feeRequest.getBasicFee().getCausaCodigoSiab(), feeRequest.getBasicFee().getOriginDestinationId(), feeRequest.getBasicFee().getCodigoSiab());
        Integer feePrice = utilities.adjustTotalTarifaBase(basicFeeDao, feeRequest.getBasicFee().getTotalKms());
        List<AdicionalEstandarDao> additionalStandardDao = adicionalesEstandarRepository.getPrice(feeRequest.getStandardAdditional());
        List<AdicionalOperativoDao> additionalOperativeDao = adicionalesOperativosRepository.getPrice(feeRequest.getOperativeAdditional());
        Integer feeStandardPrice = utilities.calculateAdditionalStandard(feeRequest.getStandardAdditional(), additionalStandardDao);
        Integer feeOperativePrice = utilities.calculateAdditionalOperative(feeRequest.getOperativeAdditional(), additionalOperativeDao);
        Integer totalFee = utilities.calculateTotalFee(feePrice, feeStandardPrice, feeOperativePrice);
        System.out.println("totalFee: " + totalFee);
        //persista
        return basicFeeDao;
    }
}
