package com.cls.model.mapper.addfee;
import com.cls.model.dto.addfee.FeeDetail;
import com.cls.model.entity.addfee.FeeDetailEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class FeeDetailMapper {

    private ModelMapper modelMapper;

    public FeeDetailMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FeeDetailEntity dtoToEntity (FeeDetail dto) {
        return modelMapper.map(dto, FeeDetailEntity.class);
    }
}
