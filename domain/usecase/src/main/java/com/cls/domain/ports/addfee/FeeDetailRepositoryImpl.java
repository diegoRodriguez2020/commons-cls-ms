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
@Transactional
@Repository
public class FeeDetailRepositoryImpl implements FeeDetailRepository {

    private EntityManager entityManager;
    private static final Logger logger = LogManager.getLogger(FeeDetailRepositoryImpl.class);
    public FeeDetailRepositoryImpl(EntityManagerFactory emf) {
        this.entityManager = emf.createEntityManager();
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

        if (builder != null && builder.isActive()){
            builder.rollback();
        }
            logger.info("error feeDetail");
        return false;
        }
    }
}