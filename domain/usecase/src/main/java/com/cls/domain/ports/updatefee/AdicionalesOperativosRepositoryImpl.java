package com.cls.domain.ports.updatefee;


import com.cls.domain.ports.updatefee.out.AdicionalesOperativosRepository;
import com.cls.model.dao.updatefee.AdicionalOperativoDao;
import com.cls.model.dto.updatefee.TarifaAdicional;
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
    public List<AdicionalOperativoDao> getPrice(List<TarifaAdicional> tarifaAdicional) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdicionalOperativoDao> query = builder.createQuery(AdicionalOperativoDao.class);
        Root<AdicionalOperativoDao> root = query.from(AdicionalOperativoDao.class);

        Predicate[] predicates = new Predicate[tarifaAdicional.size()];
        for (int index = 0; index < predicates.length; index++) {
            predicates[index] = builder.equal(root.get("id"), tarifaAdicional.get(index).getCode());
        }

        Predicate finalPredicate = builder.or(predicates);

        query.select(root).where(finalPredicate).orderBy(builder.asc(root.get("id")));

        TypedQuery<AdicionalOperativoDao> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
