package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.ConditionalsDto;
import com.aviaticket.backend.models.Conditionals;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConditionalsMapper {
    ConditionalsDto toConditionalDTO(Conditionals conditionals);

    List<ConditionalsDto> toConditionalDTOs(List<Conditionals> conditionalsList);

    Conditionals toConditional(ConditionalsDto conditionalsDto);
}
