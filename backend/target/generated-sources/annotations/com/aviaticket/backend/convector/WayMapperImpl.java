package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.WayDto;
import com.aviaticket.backend.models.Way;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T11:08:49+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class WayMapperImpl implements WayMapper {

    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private PlaneMapper planeMapper;

    @Override
    public WayDto toWayDTO(Way way) {
        if ( way == null ) {
            return null;
        }

        WayDto wayDto = new WayDto();

        wayDto.setPointFirstDto( pointMapper.toPointDTO( way.getPointFirst() ) );
        wayDto.setPointEndDto( pointMapper.toPointDTO( way.getPointEnd() ) );
        wayDto.setPlaneDto( planeMapper.toPlaneDTO( way.getPlane() ) );
        wayDto.setIdWay( way.getIdWay() );

        return wayDto;
    }

    @Override
    public List<WayDto> toWayDTOs(List<Way> ways) {
        if ( ways == null ) {
            return null;
        }

        List<WayDto> list = new ArrayList<WayDto>( ways.size() );
        for ( Way way : ways ) {
            list.add( toWayDTO( way ) );
        }

        return list;
    }

    @Override
    public Way toWay(WayDto wayDto) {
        if ( wayDto == null ) {
            return null;
        }

        Way way = new Way();

        way.setPointFirst( pointMapper.toPoint( wayDto.getPointFirstDto() ) );
        way.setPointEnd( pointMapper.toPoint( wayDto.getPointEndDto() ) );
        way.setPlane( planeMapper.toPlane( wayDto.getPlaneDto() ) );
        way.setIdWay( wayDto.getIdWay() );

        return way;
    }
}
