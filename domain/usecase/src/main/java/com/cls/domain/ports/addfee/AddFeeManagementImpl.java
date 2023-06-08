package com.cls.domain.ports.addfee;

import com.cls.domain.ports.addfee.in.AddFeeManagement;
import com.cls.domain.ports.addfee.out.ViewFeesRepository;
import com.cls.domain.ports.updatefee.out.AdditionalStandardsRepository;
import com.cls.domain.ports.updatefee.out.AddtionalOperationsRepository;
import com.cls.domain.ports.commons.utilities.FeeCalculator;
import com.cls.model.dao.addfee.ViewFeesDao;
import com.cls.model.dao.commons.AdditionalStandardsDao;
import com.cls.model.dao.commons.AdditionalOperationsDao;
import com.cls.model.request.addfee.AddFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddFeeManagementImpl implements AddFeeManagement {
    private ViewFeesRepository viewFeesRepository;
    private AdditionalStandardsRepository additionalStandardsRepository;
    private AddtionalOperationsRepository addtionalOperationsRepository;
    private FeeCalculator feeCalculator;


    public AddFeeManagementImpl(ViewFeesRepository viewFeesRepository, FeeCalculator feeCalculator, AdditionalStandardsRepository additionalStandardsRepository, AddtionalOperationsRepository addtionalOperationsRepository) {
        this.viewFeesRepository = viewFeesRepository;
        this.feeCalculator = feeCalculator;
        this.additionalStandardsRepository = additionalStandardsRepository;
        this.addtionalOperationsRepository = addtionalOperationsRepository;
    }

    @Override
    public AddFeeResponse calculateFee(AddFeeRequest addFeeRequest) {
        List<ViewFeesDao> viewFeesDao = viewFeesRepository.findFee(addFeeRequest.getBasicFee().getRamoCodigoSiab(), addFeeRequest.getBasicFee().getProductoCodigoSiab(), addFeeRequest.getBasicFee().getCausaCodigoSiab(), addFeeRequest.getBasicFee().getOriginDestinationId(), addFeeRequest.getBasicFee().getCodigoSiab());
        Integer feeValue = feeCalculator.calculateFee(viewFeesDao, addFeeRequest.getBasicFee().getTotalKms());
        List<AdditionalStandardsDao> additionalStandardsDao = additionalStandardsRepository.findStandardsList(addFeeRequest.getStandardAdditional());
        List<AdditionalOperationsDao> additionalOperativeDao = addtionalOperationsRepository.findOperationsList(addFeeRequest.getOperativeAdditional());
        Integer feeStandardValue = feeCalculator.calculateTotalAdditionalStandardsFee(addFeeRequest.getStandardAdditional(), additionalStandardsDao);
        Integer feeOperationsValue = feeCalculator.calculateTotalAdditionalOperationsFee(addFeeRequest.getOperativeAdditional(), additionalOperativeDao);
        Integer totalFeeValue = feeCalculator.calculateTotalFee(feeValue, feeStandardValue, feeOperationsValue);
        //persistir
        return AddFeeResponse.builder().authorizationNumber(addFeeRequest.getAuthorizationNumber()).basicFee(feeValue).additionalStandardFee(feeStandardValue).additionalOperationsFee(feeOperationsValue).totalFee(totalFeeValue).build();
    }
}
