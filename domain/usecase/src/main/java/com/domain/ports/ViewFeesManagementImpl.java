package com.domain.ports;

import com.domain.ports.in.ViewFeesManagement;
import com.domain.ports.out.ViewFeesManagementRepository;
import com.model.dao.ObtenerTarifaBasicaDao;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ViewFeesManagementImpl implements ViewFeesManagement {
    private ViewFeesManagementRepository viewFeesManagementRepository;

    public ViewFeesManagementImpl(ViewFeesManagementRepository viewFeesManagementRepository) {
        this.viewFeesManagementRepository = viewFeesManagementRepository;
    }

    @Override
    public List<ObtenerTarifaBasicaDao> getFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiab, Integer totalKms) {
        return viewFeesManagementRepository.findBasicFee(ramoCodigoSiab, productoCodigoSiab, causaCodigoSiab, originDestinationId, codigoSiab);
    }
}
