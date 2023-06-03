package com.bolivar.commons.actualizartarifaadicionales.utils;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class Utilities {
    public Integer calculateAdditionalOperative(List<TarifaAdicional> operativeAdditionalRequest, List<AdicionalOperativoDao> adicionalOperativoPrice) {
        int totalOperativeFee = 0;
        for (int index = 0; index < operativeAdditionalRequest.size(); index++) {
            if (operativeAdditionalRequest.get(index).getAmount() != null && operativeAdditionalRequest.get(index).getAmount() > 0) {
                totalOperativeFee += operativeAdditionalRequest.get(index).getAmount() * adicionalOperativoPrice.get(index).getPrice();
            }else{
                totalOperativeFee += adicionalOperativoPrice.get(index).getPrice();
            }
            System.out.println("totalOperativeFee: " + totalOperativeFee);
        }
        return totalOperativeFee;
    }

    public Integer calculateAdditionalStandard(List<TarifaAdicional> standardAdditional, List<AdicionalEstandarDao> adicionalEstandarPrice) {
        int totalStandardFee = 0;
        for (int index = 0; index < standardAdditional.size(); index++) {
            if (standardAdditional.get(index).getAmount() != null && standardAdditional.get(index).getAmount() > 0) {
                totalStandardFee += standardAdditional.get(index).getAmount() * adicionalEstandarPrice.get(index).getPrice();
            }else{
                totalStandardFee += adicionalEstandarPrice.get(index).getPrice();
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateTotalFee(int standardFee, int operativeFee) {
        return standardFee+operativeFee;
    }
}
