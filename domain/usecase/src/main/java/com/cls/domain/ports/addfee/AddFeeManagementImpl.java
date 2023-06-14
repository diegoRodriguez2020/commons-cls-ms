package com.cls.domain.ports.addfee;

import com.cls.domain.ports.addfee.in.AddFeeManagement;
import com.cls.domain.ports.addfee.out.FeeDetailRepository;
import com.cls.domain.ports.addfee.out.ViewFeeRepository;
import com.cls.domain.ports.commons.utilities.Utilities;
import com.cls.domain.ports.updatefee.out.AdditionalStandardsRepository;
import com.cls.domain.ports.updatefee.out.AddtionalOperationsRepository;
import com.cls.domain.ports.commons.utilities.FeeCalculator;
import com.cls.model.dto.addfee.FeeDetail;
import com.cls.model.dto.addfee.ViewFee;
import com.cls.model.dto.commons.AdditionalOperation;
import com.cls.model.dto.commons.AdditionalStandard;
import com.cls.model.dto.commons.LogsRequest;
import com.cls.model.entity.addfee.ViewFeeEntity;
import com.cls.model.entity.commons.AdditionalStandardEntity;
import com.cls.model.entity.commons.AdditionalOperationEntity;
import com.cls.model.mapper.addfee.FeeDetailMapper;
import com.cls.model.mapper.addfee.ViewFeeMapper;
import com.cls.model.mapper.commons.AdditionalOperationMapper;
import com.cls.model.mapper.commons.AdditionalStandardMapper;
import com.cls.model.request.addfee.AddFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AddFeeManagementImpl implements AddFeeManagement {
    private ViewFeeRepository viewFeeRepository;
    private AdditionalStandardsRepository additionalStandardsRepository;
    private AddtionalOperationsRepository addtionalOperationsRepository;
    private FeeDetailRepository feeDetailRepository;
    private ViewFeeMapper viewFeeMapper;
    private AdditionalStandardMapper additionalStandardMapper;
    private AdditionalOperationMapper additionalOperationMapper;
    private FeeDetailMapper feeDetailMapper;
    private FeeCalculator feeCalculator;
    private Utilities utilities;


    public AddFeeManagementImpl(ViewFeeRepository viewFeeRepository, FeeCalculator feeCalculator, AdditionalStandardsRepository additionalStandardsRepository, AddtionalOperationsRepository addtionalOperationsRepository, ViewFeeMapper viewFeeMapper, AdditionalStandardMapper additionalStandardMapper, AdditionalOperationMapper additionalOperationMapper, FeeDetailRepository feeDetailRepository, FeeDetailMapper feeDetailMapper, Utilities utilities) {
        this.viewFeeRepository = viewFeeRepository;
        this.feeCalculator = feeCalculator;
        this.additionalStandardsRepository = additionalStandardsRepository;
        this.addtionalOperationsRepository = addtionalOperationsRepository;
        this.feeDetailRepository = feeDetailRepository;
        this.viewFeeMapper = viewFeeMapper;
        this.additionalStandardMapper = additionalStandardMapper;
        this.additionalOperationMapper = additionalOperationMapper;
        this.feeDetailMapper = feeDetailMapper;
        this.utilities = utilities;
    }

    @Override
    public AddFeeResponse calculateFee(AddFeeRequest addFeeRequest) {
        ViewFee viewFee = getViewFee(addFeeRequest);
        BigDecimal feeValue = feeCalculator.calculateFee(viewFee, addFeeRequest.getBasicFee().getTotalKms());

        List<AdditionalStandard> additionalStandards = getAdditionalStandards(addFeeRequest);
        List<AdditionalOperation> additionalOperations = getAdditionalOperations(addFeeRequest);
        BigDecimal feeStandardValue = feeCalculator.calculateTotalAdditionalStandardsFee(addFeeRequest.getStandardAdditional(), additionalStandards);
        BigDecimal feeOperationsValue = feeCalculator.calculateTotalAdditionalOperationsFee(addFeeRequest.getOperativeAdditional(), additionalOperations);

        BigDecimal totalFeeValue = feeCalculator.calculateTotalFee(feeValue, feeStandardValue, feeOperationsValue);

        saveFeeDetail(addFeeRequest, viewFee, feeValue, feeStandardValue, totalFeeValue);

        return buildAddFeeResponse(addFeeRequest, feeValue, feeStandardValue, feeOperationsValue, totalFeeValue);
    }

    private ViewFee getViewFee(AddFeeRequest addFeeRequest) {
        ViewFeeEntity viewFeeEntity = viewFeeRepository.findFee(addFeeRequest);
        return viewFeeMapper.entityToDto(viewFeeEntity);
    }

    private List<AdditionalStandard> getAdditionalStandards(AddFeeRequest addFeeRequest) {
        List<AdditionalStandardEntity> additionalStandardsEntity = additionalStandardsRepository.findStandardsList(addFeeRequest.getStandardAdditional());
        return additionalStandardMapper.entitiesToDto(additionalStandardsEntity);
    }

    private List<AdditionalOperation> getAdditionalOperations(AddFeeRequest addFeeRequest) {
        List<AdditionalOperationEntity> additionalOperationsEntity = addtionalOperationsRepository.findOperationsList(addFeeRequest.getOperativeAdditional());
        return additionalOperationMapper.entitiesToDto(additionalOperationsEntity);
    }

    private void saveFeeDetail(AddFeeRequest addFeeRequest, ViewFee viewFee, BigDecimal feeValue, BigDecimal feeStandardValue, BigDecimal totalFeeValue) {
        LogsRequest logsRequest = LogsRequest.builder().addFeeRequest(addFeeRequest).build();

        FeeDetail feeDetail = new FeeDetail();
        feeDetail.setAuthorizationNumber(addFeeRequest.getAuthorizationNumber());
        feeDetail.setFeeId(viewFee.getFeeId());
        feeDetail.setFeeBasicPrice(feeValue);
        feeDetail.setFeeAdditionalPrice(feeStandardValue);
        feeDetail.setFeeTotal(totalFeeValue);
        feeDetail.setCreatedAt(utilities.getDate());
        feeDetail.setUpdatedAt(utilities.getDate());
        feeDetail.setFeeLog(utilities.convertJsonToStringLogsRequest(logsRequest));

        feeDetailRepository.addFeeDetail(feeDetailMapper.dtoToEntity(feeDetail));
    }

    private AddFeeResponse buildAddFeeResponse(AddFeeRequest addFeeRequest, BigDecimal feeValue, BigDecimal feeStandardValue, BigDecimal feeOperationsValue, BigDecimal totalFeeValue) {
        return AddFeeResponse.builder()
                .authorizationNumber(addFeeRequest.getAuthorizationNumber())
                .basicFee(String.valueOf(feeValue))
                .additionalStandardFee(String.valueOf(feeStandardValue))
                .additionalOperationsFee(String.valueOf(feeOperationsValue))
                .totalFee(String.valueOf(totalFeeValue))
                .build();
    }


}
