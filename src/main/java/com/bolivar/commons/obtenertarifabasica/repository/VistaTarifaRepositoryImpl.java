package com.bolivar.commons.obtenertarifabasica.repository;

import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VistaTarifaRepositoryImpl implements VistaTarifaRepository {
    private EntityManager entityManager;
    public VistaTarifaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<ObtenerTarifaBasicaDao> findBasicFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiabCity) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObtenerTarifaBasicaDao> query = builder.createQuery(ObtenerTarifaBasicaDao.class);
        Root<ObtenerTarifaBasicaDao> root = query.from(ObtenerTarifaBasicaDao.class);

        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("ramoCodigoSiab"), ramoCodigoSiab),
                builder.equal(root.get("productoCodigoSiab"), productoCodigoSiab),
                builder.equal(root.get("causaCodigoSiab"), causaCodigoSiab),
                builder.or(builder.equal(root.get("ciudadCodigoSiab"), codigoSiabCity),
                        builder.isNull(root.get("cityId"))));

        if (originDestinationId != null) {
            dynamicPredicate = builder.and(dynamicPredicate,
                    builder.equal(root.get("originDestinationId"), originDestinationId));
        }

        query.select(root).where(dynamicPredicate)
                .orderBy(builder.asc(builder.nullif(root.get("cityId"), -1)));

        TypedQuery<ObtenerTarifaBasicaDao> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getResultList();
    }
}
