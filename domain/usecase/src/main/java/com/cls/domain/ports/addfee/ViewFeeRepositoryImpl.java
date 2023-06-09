package com.cls.domain.ports.addfee;


import com.cls.domain.ports.addfee.out.ViewFeeRepository;
import com.cls.model.entity.addfee.ViewFeeEntity;
import com.cls.model.request.addfee.AddFeeRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Level;

@Repository
public class ViewFeeRepositoryImpl implements ViewFeeRepository {


    private static final java.util.logging.Logger log=java.util.logging.Logger.getLogger("ViewFeesManagementRepositoryImpl");
    private EntityManager entityManager;
    public ViewFeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<ViewFeeEntity>  findFee(AddFeeRequest addFeeRequest) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        log.log(Level.INFO, "getBranchCode [{0}]", new Object[]{addFeeRequest.getBasicFee().getBranchCode()});
        CriteriaQuery<ViewFeeEntity> query = builder.createQuery(ViewFeeEntity.class);
        log.log(Level.INFO, "getProductCode [{0}]", new Object[]{addFeeRequest.getBasicFee().getProductCode()});
        Root<ViewFeeEntity> root = query.from(ViewFeeEntity.class);
        log.log(Level.INFO, "getCauseCode [{0}]", new Object[]{addFeeRequest.getBasicFee().getCauseCode()});
        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("branchCode"), addFeeRequest.getBasicFee().getBranchCode()),
                builder.equal(root.get("productCode"), addFeeRequest.getBasicFee().getProductCode()),
                builder.equal(root.get("causeCode"), addFeeRequest.getBasicFee().getCauseCode()),
                builder.equal(root.get("serviceCode"), addFeeRequest.getBasicFee().getServiceCode()),
                builder.or(builder.equal(root.get("cityCode"), addFeeRequest.getBasicFee().getCityCode()),
                        builder.isNull(root.get("cityId"))));
        log.log(Level.INFO, "dynamicPredicate [{0}]", new Object[]{dynamicPredicate});
        if (addFeeRequest.getBasicFee().getOriginDestinationId() != null) {
            dynamicPredicate = builder.and(dynamicPredicate,
                    builder.equal(root.get("originDestinationId"), addFeeRequest.getBasicFee().getOriginDestinationId()));
        }

        query.select(root).where(dynamicPredicate)
                .orderBy(builder.asc(builder.nullif(root.get("cityId"), -1)));

        TypedQuery<ViewFeeEntity> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getResultList();
    }
}
