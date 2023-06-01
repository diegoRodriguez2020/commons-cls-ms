package com.bolivar.commons.commons.repositories;

import com.bolivar.commons.obtenertarifas.dao.GetTariffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GetTariffsRepositoryImpl implements GetTariffsRepository {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<GetTariffDao> findTariff(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiabCity) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GetTariffDao> query = builder.createQuery(GetTariffDao.class);
        Root<GetTariffDao> root = query.from(GetTariffDao.class);

        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("ramoCodigoSiab"), ramoCodigoSiab),
                builder.equal(root.get("productoCodigoSiab"), productoCodigoSiab),
                builder.equal(root.get("causaCodigoSiab"), causaCodigoSiab),
                builder.or(builder.equal(root.get("codigoSiab"), codigoSiabCity),
                        builder.isNull(root.get("cityId"))));

        if (originDestinationId != null) {
            dynamicPredicate = builder.and(dynamicPredicate,
                    builder.equal(root.get("originDestinationId"), originDestinationId));
        }

        query.select(root).where(dynamicPredicate)
                .orderBy(builder.asc(builder.nullif(root.get("cityId"), -1)));

        TypedQuery<GetTariffDao> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getResultList();
    }
}
