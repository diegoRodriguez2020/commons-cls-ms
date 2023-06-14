package com.cls.domain.ports.addfee;

import com.cls.domain.ports.addfee.out.FeeDetailRepository;
import com.cls.model.entity.addfee.FeeDetailEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Transactional
@Repository
public class FeeDetailRepositoryImpl implements FeeDetailRepository {

    private EntityManager entityManager;
    private static final Logger logger = LogManager.getLogger(FeeDetailRepositoryImpl.class);

    public FeeDetailRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean addFeeDetail(FeeDetailEntity feeDetailEntity) {
        EntityTransaction builder = entityManager.getTransaction();
        try {
            builder.begin();
            entityManager.persist(feeDetailEntity);
            builder.commit();
            logger.info("success feedtail");
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            if (builder != null && builder.isActive()) {
                builder.rollback();
            }
            logger.info("error feeDetail");
            return false;
        }
    }

    @Override
    public FeeDetailEntity findFeeDetailByAuthorizationNumber(int authorizationNumber) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FeeDetailEntity> query = builder.createQuery(FeeDetailEntity.class);
        Root<FeeDetailEntity> root = query.from(FeeDetailEntity.class);

        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("authorizationNumber"), authorizationNumber));

        query.select(root).where(dynamicPredicate);

        TypedQuery<FeeDetailEntity> typedQuery = entityManager.createQuery(query);

        return typedQuery.getSingleResult();
    }

    @Override
    public FeeDetailEntity updateFeeDetail(FeeDetailEntity feeDetailEntity) {
        entityManager.getTransaction().begin();
        FeeDetailEntity updateFeeDetailEntity = entityManager.find(FeeDetailEntity.class, feeDetailEntity.getId());
        updateFeeDetailEntity.setFeeBasicPrice(feeDetailEntity.getFeeBasicPrice());
        updateFeeDetailEntity.setFeeAdditionalPrice(feeDetailEntity.getFeeAdditionalPrice());
        updateFeeDetailEntity.setFeeTotal(feeDetailEntity.getFeeTotal());
        updateFeeDetailEntity.setFeeLog(feeDetailEntity.getFeeLog());
        updateFeeDetailEntity.setUpdatedAt(feeDetailEntity.getUpdatedAt());
        entityManager.getTransaction().commit();
        return updateFeeDetailEntity;
    }
}