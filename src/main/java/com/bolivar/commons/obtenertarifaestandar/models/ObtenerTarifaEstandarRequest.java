package com.bolivar.commons.obtenertarifaestandar.models;

import lombok.*;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObtenerTarifaEstandarRequest {

    private String ramoCodigoSiab;
    private String productoCodigoSiab;
    private Integer causaCodigoSiab;
    private Integer originDestinationId;
    private Integer ciudadCodigoSiab;
}
