package com.cls.domain.ports.commons.utilities;


import com.cls.model.dto.addfee.ViewFee;
import com.cls.model.dto.commons.AdditionalOperation;
import com.cls.model.dto.commons.AdditionalStandard;
import com.cls.model.entity.addfee.ViewFeeEntity;
import com.cls.model.entity.commons.AdditionalStandardEntity;
import com.cls.model.entity.commons.AdditionalOperationEntity;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class FeeCalculator {

    public Integer calculateFee(List<ViewFee> feeBasic, Integer totalKms) {
        System.out.println("totalKms: " + totalKms);
        System.out.println("feeBasic.isEmpty(): " + feeBasic.isEmpty());
        Integer feePrice = 0;
        if (totalKms != null && totalKms > 0 && !feeBasic.isEmpty()) {
            ViewFee firstFee = feeBasic.get(0);
            feePrice = firstFee.getFeePrice() + (firstFee.getFeePriceXKm() * totalKms);
        }
        System.out.println("feePrice: " + feePrice);
        return feePrice;
    }

    public Integer calculateTotalAdditionalOperationsFee(List<AdditionalFee> operativeAdditionalsRequest, List<AdditionalOperation> operativeAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdditionalOperation additionalOperation : operativeAdditionalsDataBase) {
            if (additionalOperation.getOperationId() == 1) {
                totalStandardFee += additionalOperation.getPrice();
            } else {
                for (AdditionalFee additionalFee : operativeAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), additionalOperation.getId())) {
                        totalStandardFee += additionalFee.getAmount() * additionalOperation.getPrice();
                        operativeAdditionalsRequest.remove(additionalFee);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateTotalAdditionalStandardsFee(List<AdditionalFee> standardAdditionalsRequest, List<AdditionalStandard> standardAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdditionalStandard additionalStandard : standardAdditionalsDataBase) {
            if (additionalStandard.getOperationId() == 1) {
                totalStandardFee += additionalStandard.getPrice();
            } else {
                for (AdditionalFee additionalFee : standardAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), additionalStandard.getId())) {
                        totalStandardFee += additionalFee.getAmount() * additionalStandard.getPrice();
                        standardAdditionalsRequest.remove(additionalFee);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateTotalFee(int baseFee, int standardFee, int operativeFee) {
        return baseFee + standardFee + operativeFee;
    }
}
