package com.cls.domain.ports.updatefee;


import com.cls.domain.ports.updatefee.out.AdicionalesEstandarRepository;
import com.cls.model.dao.updatefee.AdicionalEstandarDao;
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
public class AdicionalesEstandarRepositoryImpl implements AdicionalesEstandarRepository {
    private EntityManager entityManager;

    public AdicionalesEstandarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AdicionalEstandarDao> getPrice(List<TarifaAdicional> tarifaAdicional) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdicionalEstandarDao> query = builder.createQuery(AdicionalEstandarDao.class);
        Root<AdicionalEstandarDao> root = query.from(AdicionalEstandarDao.class);

        Predicate[] predicates = new Predicate[tarifaAdicional.size()];
        for (int index = 0; index < predicates.length; index++) {
            predicates[index] = builder.equal(root.get("id"), tarifaAdicional.get(index).getCode());
        }

        Predicate finalPredicate = builder.or(predicates);

        query.select(root).where(finalPredicate).orderBy(builder.asc(root.get("id")));

        TypedQuery<AdicionalEstandarDao> typedQuery = entityManager.createQuery(query);


        return typedQuery.getResultList();


    }
}
