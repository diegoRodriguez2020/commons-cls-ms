package com.cls.domain.ports.getbasicfee.in;

import com.cls.model.dao.getbasicfee.BasicFeeDao;
import com.cls.model.request.getbasicfee.FeeRequest;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ViewFeesManagement {

    List<BasicFeeDao> getFee(FeeRequest feeRequest);

}
