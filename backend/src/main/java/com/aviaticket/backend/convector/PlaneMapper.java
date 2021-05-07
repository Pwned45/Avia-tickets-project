package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.PlaneDto;
import com.aviaticket.backend.models.Plane;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaneMapper {

    PlaneDto toPlaneDTO(Plane plane);

    List<PlaneDto> toPlaneDTOs(List<Plane> planes);

    Plane toPlane(PlaneDto planeDto);
}
