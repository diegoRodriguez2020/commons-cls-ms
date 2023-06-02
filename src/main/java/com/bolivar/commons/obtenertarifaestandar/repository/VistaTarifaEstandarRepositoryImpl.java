package com.bolivar.commons.obtenertarifaestandar.repository;

import com.bolivar.commons.obtenertarifaestandar.dao.ObtenerTarifaEstandarDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VistaTarifaEstandarRepositoryImpl implements VistaTarifaEstandarRepository {
    private EntityManager entityManager;
    public VistaTarifaEstandarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<ObtenerTarifaEstandarDao> findStandardFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiabCity) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObtenerTarifaEstandarDao> query = builder.createQuery(ObtenerTarifaEstandarDao.class);
        Root<ObtenerTarifaEstandarDao> root = query.from(ObtenerTarifaEstandarDao.class);

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

        TypedQuery<ObtenerTarifaEstandarDao> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getResultList();
    }
}
