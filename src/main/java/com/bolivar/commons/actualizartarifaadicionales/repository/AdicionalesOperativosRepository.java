package com.bolivar.commons.actualizartarifaadicionales.repository;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionalesOperativosRepository {
    AdicionalOperativoDao getPrice(@Param("id") String aditionalOperationCode);
}
