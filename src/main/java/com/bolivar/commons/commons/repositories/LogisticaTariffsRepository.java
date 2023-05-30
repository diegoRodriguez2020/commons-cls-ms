package com.bolivar.commons.commons.repositories;

import com.bolivar.commons.obtenertarifas.dao.ObtenerTarifasDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogisticaTariffsRepository {
    @Select("SELECT * FROM logistica.tariffs")
    List<ObtenerTarifasDao> getList();
}
