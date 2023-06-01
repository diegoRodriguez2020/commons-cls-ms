package com.bolivar.commons.commons.repositories;

import com.bolivar.commons.obtenertarifas.dao.ObtenerTarifasDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogisticaTariffsRepository extends JpaRepository<ObtenerTarifasDao, Integer> {
    @Override
    List<ObtenerTarifasDao> findAll();
}
