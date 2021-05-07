package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.LocationDto;
import com.aviaticket.backend.models.Location;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toLocationDTO(Location location);

    List<LocationDto> toLocationDTOs(List<Location> locations);

    Location toLocation(LocationDto locationDto);
}
