package com.bolivar.commons.obtenertarifaestandar.repository;

import com.bolivar.commons.obtenertarifaestandar.dao.ObtenerTarifaEstandarDao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VistaTarifaEstandarRepository {
    List<ObtenerTarifaEstandarDao> findStandardFee(@Param("ramo_codigo_siab") String ramoCodigoSiab,
                                                   @Param("producto_codigo_siab") String productoCodigoSiab,
                                                   @Param("causa_codigo_siab") Integer causaCodigoSiab,
                                                   @Param("origin_destination_id") Integer originDestinationId,
                                                   @Param("codigo_siab_city") Integer codigoSiabCity);
}
