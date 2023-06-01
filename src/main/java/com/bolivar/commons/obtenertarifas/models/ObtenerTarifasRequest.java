package com.bolivar.commons.obtenertarifas.models;


import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObtenerTarifasRequest {

    private String ramoCodigoSiab;
    private String productoCodigoSiab;
    private Integer causaCodigoSiab;
    private Integer originDestinationId;
    private Integer codigoSiab;
}
