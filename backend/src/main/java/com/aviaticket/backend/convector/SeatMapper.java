package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.PointDto;
import com.aviaticket.backend.dto.SeatDto;
import com.aviaticket.backend.models.Point;
import com.aviaticket.backend.models.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PlaneMapper.class})
public interface SeatMapper {
    @Mapping(source = "plane", target = "planeDto")
    SeatDto toSeatDTO(Seat seat);

    List<SeatDto> toSeatDTOs(List<Seat> seats);

    @Mapping(target = "plane", source = "planeDto")
    Seat toSeat(SeatDto seatDto);
}
