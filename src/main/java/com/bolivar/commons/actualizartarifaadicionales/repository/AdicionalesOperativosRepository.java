package com.bolivar.commons.actualizartarifaadicionales.repository;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdicionalesOperativosRepository {
    List<AdicionalOperativoDao> getPrice(List<TarifaAdicional> tarifaAdicional);
}
