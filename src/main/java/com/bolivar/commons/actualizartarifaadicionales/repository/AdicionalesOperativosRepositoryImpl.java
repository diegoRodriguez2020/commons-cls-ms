package com.bolivar.commons.actualizartarifaadicionales.repository;

import com.bolivar.commons.actualizartarifaadicionales.dao.AdicionalOperativoDao;
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
public class AdicionalesOperativosRepositoryImpl implements AdicionalesOperativosRepository {
    private EntityManager entityManager;
    public AdicionalesOperativosRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public AdicionalOperativoDao getPrice(String code) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdicionalOperativoDao> query = builder.createQuery(AdicionalOperativoDao.class);
        Root<AdicionalOperativoDao> root = query.from(AdicionalOperativoDao.class);

        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("id"), code));

        query.select(root).where(dynamicPredicate);

        TypedQuery<AdicionalOperativoDao> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getSingleResult();
    }
}
