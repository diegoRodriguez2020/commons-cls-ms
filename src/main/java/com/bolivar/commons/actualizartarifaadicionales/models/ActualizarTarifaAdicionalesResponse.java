package com.bolivar.commons.actualizartarifaadicionales.models;

import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTarifaAdicionalesResponse {

    private Integer standardFee;
    private Integer operativeFee;
    private Integer totalFee;

}
