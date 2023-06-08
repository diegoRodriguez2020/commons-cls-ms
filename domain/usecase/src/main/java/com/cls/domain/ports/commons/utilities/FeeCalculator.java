package com.cls.domain.ports.commons.utilities;


import com.cls.model.dao.addfee.ViewFeesDao;
import com.cls.model.dao.commons.AdditionalStandardsDao;
import com.cls.model.dao.commons.AdditionalOperationsDao;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class FeeCalculator {

    public Integer calculateFee(List<ViewFeesDao> feeBasic, Integer totalKms) {
        Integer feePrice=0;
        if (totalKms != null && totalKms > 0 && !feeBasic.isEmpty()) {
            ViewFeesDao firstFee = feeBasic.get(0);
            feePrice = firstFee.getFeePrice() + (firstFee.getFeePriceXKm() * totalKms);
        }
        System.out.println("feePrice: " + feePrice);
        return feePrice;
    }

    public Integer calculateTotalAdditionalOperationsFee(List<AdditionalFee> operativeAdditionalsRequest, List<AdditionalOperationsDao> operativeAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdditionalOperationsDao additionalOperationsDao : operativeAdditionalsDataBase) {
            if (additionalOperationsDao.getOperationId() == 1) {
                totalStandardFee += additionalOperationsDao.getPrice();
            } else {
                for (AdditionalFee additionalFee : operativeAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), additionalOperationsDao.getId())) {
                        totalStandardFee += additionalFee.getAmount() * additionalOperationsDao.getPrice();
                        operativeAdditionalsRequest.remove(additionalFee);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateTotalAdditionalStandardsFee(List<AdditionalFee> standardAdditionalsRequest, List<AdditionalStandardsDao> standardAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdditionalStandardsDao additionalStandardsDao : standardAdditionalsDataBase) {
            if (additionalStandardsDao.getOperationId() == 1) {
                totalStandardFee += additionalStandardsDao.getPrice();
            } else {
                for (AdditionalFee additionalFee : standardAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), additionalStandardsDao.getId())) {
                        totalStandardFee += additionalFee.getAmount() * additionalStandardsDao.getPrice();
                        standardAdditionalsRequest.remove(additionalFee);
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateTotalFee(int baseFee, int standardFee, int operativeFee) {
        return baseFee+ standardFee + operativeFee;
    }
}
