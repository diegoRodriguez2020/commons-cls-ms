package com.bolivar.commons.obtenertarifas.dao;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Data
@Entity
@Immutable
@Table(name="get_tariff", schema = "logistica")
public class GetTariffDao {
    @Id()
    @Column(name = "idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(name = "idtariff")
    private Integer idTariff;
    @Column(name = "nameproduct")
    private String nameProduct;
    @Column(name = "pricetariff")
    private Integer priceTariff;
    @Column(name = "nombreciudad")
    private String nombreCiudad;
    @Column(name = "nameorigindestination")
    private String nameOriginDestination;
    @Column(name = "pricexkm")
    private Integer pricexKm;
    @Column(name = "ramo_codigo_siab")
    private String ramoCodigoSiab;
    @Column(name = "producto_codigo_siab")
    private String productoCodigoSiab;
    @Column(name = "causa_codigo_siab")
    private Integer causaCodigoSiab;
    @Column(name = "origin_destination_id", nullable = true)
    private Integer originDestinationId;
    @Column(name = "codigo_siab")
    private Integer codigoSiab;
    @Column(name = "city_id")
    private Integer cityId;
}
