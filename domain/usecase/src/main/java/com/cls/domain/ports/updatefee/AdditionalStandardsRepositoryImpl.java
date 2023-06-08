package com.cls.domain.ports.updatefee;


import com.cls.domain.ports.updatefee.out.AdditionalStandardsRepository;
import com.cls.model.entity.commons.AdditionalStandardEntity;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AdditionalStandardsRepositoryImpl implements AdditionalStandardsRepository {
    private EntityManager entityManager;

    public AdditionalStandardsRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AdditionalStandardEntity> findStandardsList(List<AdditionalFee> additionalFee) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdditionalStandardEntity> query = builder.createQuery(AdditionalStandardEntity.class);
        Root<AdditionalStandardEntity> root = query.from(AdditionalStandardEntity.class);

        Predicate[] predicates = new Predicate[additionalFee.size()];
        for (int index = 0; index < predicates.length; index++) {
            predicates[index] = builder.equal(root.get("id"), additionalFee.get(index).getCode());
        }

        Predicate finalPredicate = builder.or(predicates);

        query.select(root).where(finalPredicate).orderBy(builder.asc(root.get("id")));

        TypedQuery<AdditionalStandardEntity> typedQuery = entityManager.createQuery(query);


        return typedQuery.getResultList();


    }
}
