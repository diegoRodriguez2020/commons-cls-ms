package com.cls.domain.ports.addfee.out;


import com.cls.model.entity.addfee.ViewFeeEntity;
import com.cls.model.request.addfee.AddFeeRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ViewFeeRepository {

    ViewFeeEntity findFee(AddFeeRequest addFeeRequest);

}
