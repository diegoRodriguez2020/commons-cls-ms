package com.bolivar.commons.obtenertarifas.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tariffs", schema = "logistica")
public class ObtenerTarifasDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "schedule_id")
    private Integer scheduleId;
    @Column(name = "origin_destination_id")
    private Integer originDestinationId;
    @Column
    private Integer price;
    @Column(name = "price_x_km")
    private Integer priceKm;
    @Column(name = "vehicle_id")
    private Integer vehicleId;
}
