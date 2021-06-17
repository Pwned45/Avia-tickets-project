package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.ConditionalsDto;
import com.aviaticket.backend.models.Conditionals;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T22:06:44+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ConditionalsMapperImpl implements ConditionalsMapper {

    @Override
    public ConditionalsDto toConditionalDTO(Conditionals conditionals) {
        if ( conditionals == null ) {
            return null;
        }

        ConditionalsDto conditionalsDto = new ConditionalsDto();

        conditionalsDto.setIdAdc( conditionals.getIdAdc() );
        conditionalsDto.setTitle( conditionals.getTitle() );
        conditionalsDto.setInfo( conditionals.getInfo() );
        conditionalsDto.setPrice( conditionals.getPrice() );

        return conditionalsDto;
    }

    @Override
    public List<ConditionalsDto> toConditionalDTOs(List<Conditionals> conditionalsList) {
        if ( conditionalsList == null ) {
            return null;
        }

        List<ConditionalsDto> list = new ArrayList<ConditionalsDto>( conditionalsList.size() );
        for ( Conditionals conditionals : conditionalsList ) {
            list.add( toConditionalDTO( conditionals ) );
        }

        return list;
    }

    @Override
    public Conditionals toConditional(ConditionalsDto conditionalsDto) {
        if ( conditionalsDto == null ) {
            return null;
        }

        Conditionals conditionals = new Conditionals();

        conditionals.setIdAdc( conditionalsDto.getIdAdc() );
        conditionals.setTitle( conditionalsDto.getTitle() );
        conditionals.setInfo( conditionalsDto.getInfo() );
        conditionals.setPrice( conditionalsDto.getPrice() );

        return conditionals;
    }
}
