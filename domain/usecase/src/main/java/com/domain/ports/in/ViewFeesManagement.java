package com.domain.ports.in;

import com.model.dao.ObtenerTarifaBasicaDao;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ViewFeesManagement {

    List<ObtenerTarifaBasicaDao> getFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab,
                                        Integer originDestinationId, Integer codigoSiab, Integer totalKms);

}
