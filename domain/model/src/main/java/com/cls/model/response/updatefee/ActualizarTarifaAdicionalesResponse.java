package com.cls.model.response.updatefee;

import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTarifaAdicionalesResponse {

    private Integer baseFee;
    private Integer standardFee;
    private Integer operativeFee;
    private Integer totalFee;

}
