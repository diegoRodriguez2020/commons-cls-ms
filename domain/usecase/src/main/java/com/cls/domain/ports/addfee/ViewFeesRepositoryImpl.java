package com.cls.domain.ports.addfee;


import com.cls.domain.ports.addfee.out.ViewFeesRepository;
import com.cls.model.dao.addfee.ViewFeesDao;
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
public class ViewFeesRepositoryImpl implements ViewFeesRepository {


    private static final java.util.logging.Logger log=java.util.logging.Logger.getLogger("ViewFeesManagementRepositoryImpl");
    private EntityManager entityManager;
    public ViewFeesRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<ViewFeesDao> findFee(String ramoCodigoSiab, String productoCodigoSiab, Integer causaCodigoSiab, Integer originDestinationId, Integer codigoSiabCity) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        log.log(Level.INFO, "ramoCodigoSiab [{0}]", new Object[]{ramoCodigoSiab});
        CriteriaQuery<ViewFeesDao> query = builder.createQuery(ViewFeesDao.class);
        log.log(Level.INFO, "productoCodigoSiab [{0}]", new Object[]{productoCodigoSiab});
        Root<ViewFeesDao> root = query.from(ViewFeesDao.class);
        log.log(Level.INFO, "causaCodigoSiab [{0}]", new Object[]{causaCodigoSiab});
        Predicate dynamicPredicate = builder.conjunction();

        dynamicPredicate = builder.and(dynamicPredicate,
                builder.equal(root.get("ramoCodigoSiab"), ramoCodigoSiab),
                builder.equal(root.get("productoCodigoSiab"), productoCodigoSiab),
                builder.equal(root.get("causaCodigoSiab"), causaCodigoSiab),
                builder.or(builder.equal(root.get("ciudadCodigoSiab"), codigoSiabCity),
                        builder.isNull(root.get("cityId"))));
        log.log(Level.INFO, "dynamicPredicate [{0}]", new Object[]{dynamicPredicate});
        if (originDestinationId != null) {
            dynamicPredicate = builder.and(dynamicPredicate,
                    builder.equal(root.get("originDestinationId"), originDestinationId));
        }

        query.select(root).where(dynamicPredicate)
                .orderBy(builder.asc(builder.nullif(root.get("cityId"), -1)));

        TypedQuery<ViewFeesDao> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(1);

        return typedQuery.getResultList();
    }
}
