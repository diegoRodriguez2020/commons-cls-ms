package com.cls.domain.ports.updatefee.out;


import com.cls.model.dao.updatefee.AdicionalEstandarDao;
import com.cls.model.dto.updatefee.TarifaAdicional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdicionalesEstandarRepository {
    List<AdicionalEstandarDao> getPrice(List<TarifaAdicional> tarifaAdicional);
}
