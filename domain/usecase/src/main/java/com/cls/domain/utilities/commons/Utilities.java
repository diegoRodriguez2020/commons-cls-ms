package com.cls.domain.utilities.commons;


import com.cls.model.dao.getbasicfee.BasicFeeDao;
import com.cls.model.dao.updatefee.AdicionalEstandarDao;
import com.cls.model.dao.updatefee.AdicionalOperativoDao;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class Utilities {


    public Integer adjustTotalTarifaBase(List<BasicFeeDao> feeBasic, Integer totalKms) {
        Integer feePrice=0;
        if (totalKms != null && totalKms > 0 && !feeBasic.isEmpty()) {
            BasicFeeDao firstFee = feeBasic.get(0);
            feePrice = firstFee.getFeePrice() + (firstFee.getFeePriceXKm() * totalKms);
        }
        System.out.println("feePrice: " + feePrice);
        return feePrice;
    }

    public Integer calculateAdditionalOperative(List<AdditionalFee> operativeAdditionalsRequest, List<AdicionalOperativoDao> operativeAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdicionalOperativoDao adicionalOperativoDao : operativeAdditionalsDataBase) {
            if (adicionalOperativoDao.getOperationId() == 1) {
                totalStandardFee += adicionalOperativoDao.getPrice();
            } else {
                for (AdditionalFee additionalFee : operativeAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), adicionalOperativoDao.getId())) {
                        totalStandardFee += additionalFee.getAmount() * adicionalOperativoDao.getPrice();
                        operativeAdditionalsRequest.remove(additionalFee);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateAdditionalStandard(List<AdditionalFee> standardAdditionalsRequest, List<AdicionalEstandarDao> standardAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdicionalEstandarDao adicionalEstandarDao : standardAdditionalsDataBase) {
            if (adicionalEstandarDao.getOperationId() == 1) {
                totalStandardFee += adicionalEstandarDao.getPrice();
            } else {
                for (AdditionalFee additionalFee : standardAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), adicionalEstandarDao.getId())) {
                        totalStandardFee += additionalFee.getAmount() * adicionalEstandarDao.getPrice();
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
