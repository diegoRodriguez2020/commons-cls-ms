package com.bolivar.commons.actualizartarifaadicionales.utils;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;

import java.util.List;

public class utilities {


    private void adjustTotalTarifaBase(List<ObtenerTarifaBasicaDao> tarifaBasica, Integer totalKms) {
        if (totalKms != null && totalKms > 0 && !tarifaBasica.isEmpty()) {
            ObtenerTarifaBasicaDao firstTarifa = tarifaBasica.get(0);
            Integer totalTarifaBase = firstTarifa.getFeePrice() + (firstTarifa.getFeePriceXKm() * totalKms);
            firstTarifa.setFeePrice(totalTarifaBase);
        }
    }
}
