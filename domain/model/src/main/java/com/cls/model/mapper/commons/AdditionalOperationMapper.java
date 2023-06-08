package com.cls.model.mapper.commons;

import com.cls.model.dto.commons.AdditionalOperation;
import com.cls.model.entity.commons.AdditionalOperationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdditionalOperationMapper {

    private ModelMapper modelMapper;

    public AdditionalOperationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public List<AdditionalOperation> entitiesToDto(List<AdditionalOperationEntity> entities) {
        List<AdditionalOperation> additionalOperations= new ArrayList<>();
        for (AdditionalOperationEntity entity : entities) {
            additionalOperations.add( modelMapper.map(entity, AdditionalOperation.class));
        }
        return additionalOperations;
    }
}
