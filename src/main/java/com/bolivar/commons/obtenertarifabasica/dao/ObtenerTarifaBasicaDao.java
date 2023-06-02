package com.bolivar.commons.obtenertarifabasica.dao;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Data
@Entity
@Immutable
@Table(name="view_fees")
public class ObtenerTarifaBasicaDao {
    @Id()
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "ramo_codigo_siab")
    private String ramoCodigoSiab;
    @Column(name = "producto_codigo_siab")
    private String productoCodigoSiab;
    @Column(name = "causa_codigo_siab")
    private Integer causaCodigoSiab;
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "ciudad_codigo_siab") //¿?
    private Integer ciudadCodigoSiab;
    @Column(name = "origin_destination_id")
    private Integer originDestinationId;
    @Column(name = "fee_id")
    private Integer feeId;
    @Column(name = "fee_price")
    private Integer feePrice;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "origindestination_name")//corregir en la tabla
    private String originDestinationName;
    @Column(name = "fee_pricexkm")
    private Integer feePriceXKm;
}
