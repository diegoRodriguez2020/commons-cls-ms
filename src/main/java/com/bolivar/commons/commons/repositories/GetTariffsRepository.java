package com.bolivar.commons.commons.repositories;

import com.bolivar.commons.obtenertarifas.dao.GetTariffDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetTariffsRepository extends JpaRepository<GetTariffDao, Integer> {
    @Override
    List<GetTariffDao> findAll();

    @Query(value = "SELECT * FROM get_tariff gtf WHERE gtf.ramo_codigo_siab = ?1 AND gtf.producto_codigo_siab = ?2 AND gtf.causa_codigo_siab = ?3 AND gtf.origin_destination_id = ?4 AND (gtf.codigo_siab = ?5 OR gtf.city_id IS NULL) ORDER BY gtf.city_id DESC NULLS LAST LIMIT 1", nativeQuery = true)
    List<GetTariffDao> findTariff(@Param("ramo_codigo_siab") String ramoCodigoSiab,
                                  @Param("producto_codigo_siab") String productoCodigoSiab,
                                  @Param("causa_codigo_siab") Integer causaCodigoSiab,
                                  @Param("origin_destination_id") Integer originDestinationId,
                                  @Param("codigo_siab_city") Integer codigoSiabCity);
}
