package com.bolivar.commons.actualizartarifaadicionales.utils;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class Utilities {
    public Integer calculateAdditionalOperative(List<TarifaAdicional> operativeAdditionalsRequest, List<AdicionalOperativoDao> operativeAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdicionalOperativoDao adicionalOperativoDao : operativeAdditionalsDataBase) {
            if (adicionalOperativoDao.getOperationId() == 1) {
                totalStandardFee += adicionalOperativoDao.getPrice();
            } else {
                for (TarifaAdicional tarifaAdicional : operativeAdditionalsRequest) {
                    if (Objects.equals(tarifaAdicional.getCode(), adicionalOperativoDao.getId())) {
                        totalStandardFee += tarifaAdicional.getAmount() * adicionalOperativoDao.getPrice();
                        operativeAdditionalsRequest.remove(tarifaAdicional);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public Integer calculateAdditionalStandard(List<TarifaAdicional> standardAdditionalsRequest, List<AdicionalEstandarDao> standardAdditionalsDataBase) {
        int totalStandardFee = 0;
        for (AdicionalEstandarDao adicionalEstandarDao : standardAdditionalsDataBase) {
            if (adicionalEstandarDao.getOperationId() == 1) {
                totalStandardFee += adicionalEstandarDao.getPrice();
            } else {
                for (TarifaAdicional tarifaAdicional : standardAdditionalsRequest) {
                    if (Objects.equals(tarifaAdicional.getCode(), adicionalEstandarDao.getId())) {
                        totalStandardFee += tarifaAdicional.getAmount() * adicionalEstandarDao.getPrice();
                        standardAdditionalsRequest.remove(tarifaAdicional);
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
