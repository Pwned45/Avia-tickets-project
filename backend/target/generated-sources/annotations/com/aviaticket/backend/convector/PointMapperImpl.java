package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.PointDto;
import com.aviaticket.backend.models.Point;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T22:06:44+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class PointMapperImpl implements PointMapper {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public PointDto toPointDTO(Point point) {
        if ( point == null ) {
            return null;
        }

        PointDto pointDto = new PointDto();

        pointDto.setLocationDto( locationMapper.toLocationDTO( point.getLocation() ) );
        pointDto.setIdPoint( point.getIdPoint() );
        pointDto.setIdRoute( point.getIdRoute() );
        pointDto.setAirport( point.getAirport() );
        pointDto.setNumber( point.getNumber() );

        return pointDto;
    }

    @Override
    public List<PointDto> toPointDTOs(List<Point> point) {
        if ( point == null ) {
            return null;
        }

        List<PointDto> list = new ArrayList<PointDto>( point.size() );
        for ( Point point1 : point ) {
            list.add( toPointDTO( point1 ) );
        }

        return list;
    }

    @Override
    public Point toPoint(PointDto point) {
        if ( point == null ) {
            return null;
        }

        Point point1 = new Point();

        point1.setLocation( locationMapper.toLocation( point.getLocationDto() ) );
        point1.setIdPoint( point.getIdPoint() );
        point1.setIdRoute( point.getIdRoute() );
        point1.setAirport( point.getAirport() );
        point1.setNumber( point.getNumber() );

        return point1;
    }
}
