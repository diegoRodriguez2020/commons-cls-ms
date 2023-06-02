package com.bolivar.commons.actualizartarifaadicionales.repository;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalEstandarDao;
import com.bolivar.commons.obtenertarifabasica.dao.ObtenerTarifaBasicaDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AdicionalesEstandarRepositoryImpl implements AdicionalesEstandarRepository {
    private EntityManager entityManager;
    public AdicionalesEstandarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public AdicionalEstandarDao getPrice(String code) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdicionalEstandarDao> query = builder.createQuery(AdicionalEstandarDao.class);
        Root<AdicionalEstandarDao> root = query.from(AdicionalEstandarDao.class);

        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("id"), code));

        query.select(root).where(dynamicPredicate);

        TypedQuery<AdicionalEstandarDao> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getSingleResult();
    }
}
