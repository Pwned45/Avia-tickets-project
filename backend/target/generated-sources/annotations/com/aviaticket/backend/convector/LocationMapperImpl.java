package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.LocationDto;
import com.aviaticket.backend.models.Location;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T10:44:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDto toLocationDTO(Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDto locationDto = new LocationDto();

        locationDto.setIdLocation( location.getIdLocation() );
        locationDto.setCountry( location.getCountry() );
        locationDto.setCity( location.getCity() );

        return locationDto;
    }

    @Override
    public List<LocationDto> toLocationDTOs(List<Location> locations) {
        if ( locations == null ) {
            return null;
        }

        List<LocationDto> list = new ArrayList<LocationDto>( locations.size() );
        for ( Location location : locations ) {
            list.add( toLocationDTO( location ) );
        }

        return list;
    }

    @Override
    public Location toLocation(LocationDto locationDto) {
        if ( locationDto == null ) {
            return null;
        }

        Location location = new Location();

        location.setIdLocation( locationDto.getIdLocation() );
        location.setCountry( locationDto.getCountry() );
        location.setCity( locationDto.getCity() );

        return location;
    }
}
