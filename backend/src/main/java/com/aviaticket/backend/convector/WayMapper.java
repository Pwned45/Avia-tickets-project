package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.PlaneDto;
import com.aviaticket.backend.dto.WayDto;
import com.aviaticket.backend.models.Plane;
import com.aviaticket.backend.models.Way;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PointMapper.class, PlaneMapper.class})
public interface WayMapper {
    @Mappings({
        @Mapping(source = "pointFirst", target = "pointFirstDto"),
        @Mapping(source = "pointEnd", target = "pointEndDto"),
        @Mapping(source = "plane", target = "planeDto")
    })
    WayDto toWayDTO(Way way);

    List<WayDto> toWayDTOs(List<Way> ways);

    @Mappings({
        @Mapping(target = "pointFirst", source = "pointFirstDto"),
        @Mapping(target = "pointEnd", source = "pointEndDto"),
        @Mapping(target = "plane", source = "planeDto")
    })
    Way toWay(WayDto wayDto);
}
