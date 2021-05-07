package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.PointDto;
import com.aviaticket.backend.models.Point;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface PointMapper {
    @Mapping(source = "location", target = "locationDto")
    PointDto toPointDTO(Point point);

    List<PointDto> toPointDTOs(List<Point> point);

    @Mapping(target = "location", source = "locationDto")
    Point toPoint(PointDto point);
}
