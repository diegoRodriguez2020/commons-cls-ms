package com.cls.model.mapper.addfee;

import com.cls.model.dto.addfee.ViewFee;
import com.cls.model.entity.addfee.ViewFeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ViewFeeMapper {

    private ModelMapper modelMapper;

    public ViewFeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<ViewFee> entitiesToDto(List<ViewFeeEntity> entities) {
        List<ViewFee> vieeFees= new ArrayList<>();
        for (ViewFeeEntity entity : entities) {
            vieeFees.add(modelMapper.map(entity, ViewFee.class));
        }
        return vieeFees;
    }
}
