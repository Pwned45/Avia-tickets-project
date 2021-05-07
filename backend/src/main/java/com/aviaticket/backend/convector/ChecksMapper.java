package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.models.Checks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {BidMapper.class,UserMapper.class})
public interface ChecksMapper {
    @Mappings({
        @Mapping(source = "way", target = "wayDto"),
        @Mapping(source = "seat", target = "seatDto"),
    })
    CheckDto toCheckDTO(Checks checks);

    List<CheckDto> toCheckDTOs(List<Checks> checksList);

    @Mappings({
        @Mapping(source = "way", target = "wayDto"),
        @Mapping(source = "seat", target = "seatDto"),
    })
    Checks toCheck(CheckDto checksDto);
}
