package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.PlaneDto;
import com.aviaticket.backend.models.Plane;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-18T14:38:41+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class PlaneMapperImpl implements PlaneMapper {

    @Override
    public PlaneDto toPlaneDTO(Plane plane) {
        if ( plane == null ) {
            return null;
        }

        PlaneDto planeDto = new PlaneDto();

        planeDto.setIdPlane( plane.getIdPlane() );
        planeDto.setCountRow( plane.getCountRow() );
        planeDto.setCountSeat( plane.getCountSeat() );
        planeDto.setInfo( plane.getInfo() );

        return planeDto;
    }

    @Override
    public List<PlaneDto> toPlaneDTOs(List<Plane> planes) {
        if ( planes == null ) {
            return null;
        }

        List<PlaneDto> list = new ArrayList<PlaneDto>( planes.size() );
        for ( Plane plane : planes ) {
            list.add( toPlaneDTO( plane ) );
        }

        return list;
    }

    @Override
    public Plane toPlane(PlaneDto planeDto) {
        if ( planeDto == null ) {
            return null;
        }

        Plane plane = new Plane();

        plane.setIdPlane( planeDto.getIdPlane() );
        plane.setCountRow( planeDto.getCountRow() );
        plane.setCountSeat( planeDto.getCountSeat() );
        plane.setInfo( planeDto.getInfo() );

        return plane;
    }
}
