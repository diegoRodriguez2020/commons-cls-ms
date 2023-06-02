package com.bolivar.commons.actualizartarifaadicionales.repository;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionalesEstandarRepository {
    AdicionalEstandarDao getPrice(@Param("id") String aditionalStandardCode);
}
