package com.bolivar.commons.actualizartarifaadicionales.repository;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdicionalesEstandarRepository {
    List<AdicionalEstandarDao> getPrice(List<TarifaAdicional> tarifaAdicional);
}
