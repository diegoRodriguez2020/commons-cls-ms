package com.bolivar.commons.obtenertarifas.dao;

import lombok.Data;

@Data
public class ObtenerTarifasDao {
    private Integer id;
    private Integer product;
    private Integer cityId;
    private Integer scheduleId;
    private Integer originDestinationId;
    private Integer price;
    private Integer priceKm;
}
