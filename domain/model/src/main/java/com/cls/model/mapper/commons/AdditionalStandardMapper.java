package com.cls.model.mapper.commons;

import com.cls.model.dto.commons.AdditionalStandard;
import com.cls.model.entity.commons.AdditionalStandardEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdditionalStandardMapper {

    private ModelMapper modelMapper;

    public AdditionalStandardMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public List<AdditionalStandard> entitiesToDto(List<AdditionalStandardEntity> entities) {
        List<AdditionalStandard> additionalStandards= new ArrayList<>();
        for (AdditionalStandardEntity entity : entities) {
            additionalStandards.add( modelMapper.map(entity, AdditionalStandard.class));
        }
        return additionalStandards;
    }
}
