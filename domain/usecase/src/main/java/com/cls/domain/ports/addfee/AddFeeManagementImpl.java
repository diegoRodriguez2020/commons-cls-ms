package com.cls.domain.ports.addfee;

import com.cls.domain.ports.addfee.in.AddFeeManagement;
import com.cls.domain.ports.addfee.out.FeeDetailRepository;
import com.cls.domain.ports.addfee.out.ViewFeeRepository;
import com.cls.domain.ports.updatefee.out.AdditionalStandardsRepository;
import com.cls.domain.ports.updatefee.out.AddtionalOperationsRepository;
import com.cls.domain.ports.commons.utilities.FeeCalculator;
import com.cls.model.dto.addfee.FeeDetail;
import com.cls.model.dto.addfee.ViewFee;
import com.cls.model.dto.commons.AdditionalOperation;
import com.cls.model.dto.commons.AdditionalStandard;
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

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


    public AddFeeManagementImpl(ViewFeeRepository viewFeeRepository, FeeCalculator feeCalculator, AdditionalStandardsRepository additionalStandardsRepository, AddtionalOperationsRepository addtionalOperationsRepository, ViewFeeMapper viewFeeMapper, AdditionalStandardMapper additionalStandardMapper, AdditionalOperationMapper additionalOperationMapper, FeeDetailRepository feeDetailRepository, FeeDetailMapper feeDetailMapper) {
        this.viewFeeRepository = viewFeeRepository;
        this.feeCalculator = feeCalculator;
        this.additionalStandardsRepository = additionalStandardsRepository;
        this.addtionalOperationsRepository = addtionalOperationsRepository;
        this.feeDetailRepository = feeDetailRepository;
        this.viewFeeMapper = viewFeeMapper;
        this.additionalStandardMapper = additionalStandardMapper;
        this.additionalOperationMapper = additionalOperationMapper;
        this.feeDetailMapper = feeDetailMapper;
    }

    @Override
    public AddFeeResponse calculateFee(AddFeeRequest addFeeRequest) {
        List<ViewFeeEntity> viewFeeEntity = viewFeeRepository.findFee(addFeeRequest);
        List<ViewFee> viewFee = viewFeeMapper.entitiesToDto(viewFeeEntity);
        Integer feeValue = feeCalculator.calculateFee(viewFee, addFeeRequest.getBasicFee().getTotalKms());

        List<AdditionalStandardEntity> additionalStandardsEntity = additionalStandardsRepository.findStandardsList(addFeeRequest.getStandardAdditional());
        List<AdditionalOperationEntity> additionalOperationsEntity = addtionalOperationsRepository.findOperationsList(addFeeRequest.getOperativeAdditional());
        List<AdditionalStandard> additionalStandards = additionalStandardMapper.entitiesToDto(additionalStandardsEntity);
        List<AdditionalOperation> additionalOperations = additionalOperationMapper.entitiesToDto(additionalOperationsEntity);
        Integer feeStandardValue = feeCalculator.calculateTotalAdditionalStandardsFee(addFeeRequest.getStandardAdditional(), additionalStandards);
        Integer feeOperationsValue = feeCalculator.calculateTotalAdditionalOperationsFee(addFeeRequest.getOperativeAdditional(), additionalOperations);

        Integer totalFeeValue = feeCalculator.calculateTotalFee(feeValue, feeStandardValue, feeOperationsValue);
        FeeDetail feeDetail = new FeeDetail();
        feeDetail.setAuthorizationNumber(addFeeRequest.getAuthorizationNumber());
        feeDetail.setFeeId(viewFee.get(0).getFeeId());
        feeDetail.setFeeBasicPrice(feeValue);
        feeDetail.setFeeAdditionalPrice(feeStandardValue);
        feeDetail.setFeeTotal(totalFeeValue);
        feeDetail.setFeeLog("{}");
        //Date creationDateTime = feeCalculator.getDateISO8601(ZoneOffset.UTC, DateTimeFormatter.ISO_INSTANT);
        //feeDetail.setCreatedAt(creationDateTime);
        //feeDetail.setUpdatedAt(creationDateTime);
        feeDetailRepository.addFeeDetail(feeDetailMapper.dtoToEntity(feeDetail));
        return AddFeeResponse.builder().authorizationNumber(addFeeRequest.getAuthorizationNumber()).basicFee(feeValue).additionalStandardFee(feeStandardValue).additionalOperationsFee(feeOperationsValue).totalFee(totalFeeValue).build();
    }
}
