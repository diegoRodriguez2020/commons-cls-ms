package com.cls.domain.ports.addfee;

import com.cls.domain.ports.addfee.out.FeeDetailRepository;
import com.cls.model.entity.addfee.FeeDetailEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;

@Repository
public class FeeDetailRepositoryImpl implements FeeDetailRepository {

    private EntityManager entityManager;
    private static final Logger logger = LogManager.getLogger(FeeDetailRepositoryImpl.class);
    public FeeDetailRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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

        if (builder != null && builder.isActive()){
            builder.rollback();
        }
            logger.info("error feeDetail");
        return false;
        }
    }
}