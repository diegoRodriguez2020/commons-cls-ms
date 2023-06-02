package com.bolivar.commons.obtenertarifabasica.services;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;

import java.util.List;

/**
 * <h3>This interface is an abstraction of methods for store files in a folder</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodriguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
public interface ObtenerTarifaBasicaService {
    List<ObtenerTarifaBasicaDao> getBasicFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiab);

}
