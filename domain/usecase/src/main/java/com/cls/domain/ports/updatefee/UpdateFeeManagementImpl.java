package com.cls.domain.ports.updatefee;


import com.cls.domain.ports.addfee.out.FeeDetailRepository;
import com.cls.domain.ports.addfee.out.ViewFeeRepository;
import com.cls.domain.ports.commons.utilities.Utilities;
import com.cls.domain.ports.updatefee.in.UpdateFeeManagement;
import com.cls.domain.ports.updatefee.out.AdditionalStandardsRepository;
import com.cls.domain.ports.updatefee.out.AddtionalOperationsRepository;
import com.cls.domain.ports.commons.utilities.FeeCalculator;
import com.cls.model.dto.addfee.FeeDetail;
import com.cls.model.dto.addfee.ViewFee;
import com.cls.model.dto.commons.AdditionalOperation;
import com.cls.model.dto.commons.AdditionalStandard;
import com.cls.model.dto.commons.LogsRequest;
import com.cls.model.entity.addfee.FeeDetailEntity;
import com.cls.model.entity.addfee.ViewFeeEntity;
import com.cls.model.entity.commons.AdditionalOperationEntity;
import com.cls.model.entity.commons.AdditionalStandardEntity;
import com.cls.model.mapper.addfee.FeeDetailMapper;
import com.cls.model.mapper.addfee.ViewFeeMapper;
import com.cls.model.mapper.commons.AdditionalOperationMapper;
import com.cls.model.mapper.commons.AdditionalStandardMapper;
import com.cls.model.request.updatefee.UpdateFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import com.cls.model.response.updatefee.UpdateFeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class UpdateFeeManagementImpl implements UpdateFeeManagement {
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


    public UpdateFeeManagementImpl(ViewFeeRepository viewFeeRepository, FeeCalculator feeCalculator, AdditionalStandardsRepository additionalStandardsRepository, AddtionalOperationsRepository addtionalOperationsRepository, ViewFeeMapper viewFeeMapper, AdditionalStandardMapper additionalStandardMapper, AdditionalOperationMapper additionalOperationMapper, FeeDetailRepository feeDetailRepository, FeeDetailMapper feeDetailMapper, Utilities utilities) {
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
    public UpdateFeeResponse updateFee(UpdateFeeRequest updateFeeRequest) {
        FeeDetail feeDetail = getFeeDetail(updateFeeRequest);
        BigDecimal feeValue = feeDetail.getFeeTotal();

        updateLogsRequest(feeDetail, updateFeeRequest);

        List<AdditionalStandard> additionalStandards = getAdditionalStandards(updateFeeRequest);
        List<AdditionalOperation> additionalOperations = getAdditionalOperations(updateFeeRequest);
        BigDecimal feeStandardValue = feeCalculator.calculateTotalAdditionalStandardsFee(updateFeeRequest.getStandardAdditional(), additionalStandards);
        BigDecimal feeOperationsValue = feeCalculator.calculateTotalAdditionalOperationsFee(updateFeeRequest.getOperativeAdditional(), additionalOperations);

        BigDecimal totalFeeValue = feeCalculator.calculateTotalFee(feeValue, feeStandardValue, feeOperationsValue);
        updateFeeDetail(feeDetail, feeStandardValue, totalFeeValue);

        return buildUpdateFeeResponse(updateFeeRequest, feeValue, feeStandardValue, feeOperationsValue, totalFeeValue);
    }

    private FeeDetail getFeeDetail(UpdateFeeRequest updateFeeRequest) {
        FeeDetailEntity feeDetailEntity = feeDetailRepository.findFeeDetailByAuthorizationNumber(updateFeeRequest.getAuthorizationNumber());
        return feeDetailMapper.entityToDto(feeDetailEntity);
    }

    private List<AdditionalStandard> getAdditionalStandards(UpdateFeeRequest updateFeeRequest) {
        List<AdditionalStandardEntity> additionalStandardsEntity = additionalStandardsRepository.findStandardsList(updateFeeRequest.getStandardAdditional());
        return additionalStandardMapper.entitiesToDto(additionalStandardsEntity);
    }

    private List<AdditionalOperation> getAdditionalOperations(UpdateFeeRequest updateFeeRequest) {
        List<AdditionalOperationEntity> additionalOperationsEntity = addtionalOperationsRepository.findOperationsList(updateFeeRequest.getOperativeAdditional());
        return additionalOperationMapper.entitiesToDto(additionalOperationsEntity);
    }

    private void updateLogsRequest(FeeDetail feeDetail, UpdateFeeRequest updateFeeRequest) {
        LogsRequest logsRequest = utilities.convertStringToJsonLogsRequest(feeDetail.getFeeLog());
        logsRequest.setUpdateFeeRequest(updateFeeRequest);
        feeDetail.setFeeLog(utilities.convertJsonToStringLogsRequest(logsRequest));
    }

    private void updateFeeDetail(FeeDetail feeDetail, BigDecimal feeStandardValue, BigDecimal totalFeeValue) {
        feeDetail.setFeeAdditionalPrice(feeStandardValue);
        feeDetail.setFeeTotal(totalFeeValue);
        feeDetail.setUpdatedAt(utilities.getDate());
        feeDetailRepository.updateFeeDetail(feeDetailMapper.dtoToEntity(feeDetail));
    }

    private UpdateFeeResponse buildUpdateFeeResponse(UpdateFeeRequest updateFeeRequest, BigDecimal feeValue, BigDecimal feeStandardValue, BigDecimal feeOperationsValue, BigDecimal totalFeeValue) {
        return UpdateFeeResponse.builder()
                .authorizationNumber(updateFeeRequest.getAuthorizationNumber())
                .initialFee(String.valueOf(feeValue))
                .additionalStandardFee(String.valueOf(feeStandardValue))
                .additionalOperationsFee(String.valueOf(feeOperationsValue))
                .totalFee(String.valueOf(totalFeeValue))
                .build();
    }
}
