package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.TicketDto;
import com.aviaticket.backend.models.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SeatMapper.class,WayMapper.class})
public interface TicketMapper {
    @Mappings({
        @Mapping(source = "way", target = "wayDto"),
        @Mapping(source = "seat", target = "seatDto"),
    })
    TicketDto toTicketDTO(Ticket ticket);

    List<TicketDto> toTicketDTOs(List<Ticket> tickets);

    @Mappings({
        @Mapping(target = "way", source = "wayDto"),
        @Mapping(target = "seat", source = "seatDto"),
    })
    Ticket toTicket(TicketDto ticketDto);
}
