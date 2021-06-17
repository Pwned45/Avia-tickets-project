package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.SeatDto;
import com.aviaticket.backend.models.Seat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T22:14:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class SeatMapperImpl implements SeatMapper {

    @Autowired
    private PlaneMapper planeMapper;

    @Override
    public SeatDto toSeatDTO(Seat seat) {
        if ( seat == null ) {
            return null;
        }

        SeatDto seatDto = new SeatDto();

        seatDto.setPlaneDto( planeMapper.toPlaneDTO( seat.getPlane() ) );
        seatDto.setIdSeat( seat.getIdSeat() );
        seatDto.setRow( seat.getRow() );
        seatDto.setNumberSeat( seat.getNumberSeat() );

        return seatDto;
    }

    @Override
    public List<SeatDto> toSeatDTOs(List<Seat> seats) {
        if ( seats == null ) {
            return null;
        }

        List<SeatDto> list = new ArrayList<SeatDto>( seats.size() );
        for ( Seat seat : seats ) {
            list.add( toSeatDTO( seat ) );
        }

        return list;
    }

    @Override
    public Seat toSeat(SeatDto seatDto) {
        if ( seatDto == null ) {
            return null;
        }

        Seat seat = new Seat();

        seat.setPlane( planeMapper.toPlane( seatDto.getPlaneDto() ) );
        seat.setIdSeat( seatDto.getIdSeat() );
        seat.setRow( seatDto.getRow() );
        seat.setNumberSeat( seatDto.getNumberSeat() );

        return seat;
    }
}
