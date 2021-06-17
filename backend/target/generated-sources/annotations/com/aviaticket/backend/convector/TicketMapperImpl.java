package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.TicketDto;
import com.aviaticket.backend.models.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T11:13:29+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private WayMapper wayMapper;

    @Override
    public TicketDto toTicketDTO(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        TicketDto ticketDto = new TicketDto();

        ticketDto.setWayDto( wayMapper.toWayDTO( ticket.getWay() ) );
        ticketDto.setSeatDto( seatMapper.toSeatDTO( ticket.getSeat() ) );
        ticketDto.setIdTicket( ticket.getIdTicket() );
        ticketDto.setStartDate( ticket.getStartDate() );
        ticketDto.setEndDate( ticket.getEndDate() );
        ticketDto.setPrice( ticket.getPrice() );
        ticketDto.setFlag( ticket.getFlag() );

        return ticketDto;
    }

    @Override
    public List<TicketDto> toTicketDTOs(List<Ticket> tickets) {
        if ( tickets == null ) {
            return null;
        }

        List<TicketDto> list = new ArrayList<TicketDto>( tickets.size() );
        for ( Ticket ticket : tickets ) {
            list.add( toTicketDTO( ticket ) );
        }

        return list;
    }

    @Override
    public Ticket toTicket(TicketDto ticketDto) {
        if ( ticketDto == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setWay( wayMapper.toWay( ticketDto.getWayDto() ) );
        ticket.setSeat( seatMapper.toSeat( ticketDto.getSeatDto() ) );
        ticket.setIdTicket( ticketDto.getIdTicket() );
        ticket.setStartDate( ticketDto.getStartDate() );
        ticket.setEndDate( ticketDto.getEndDate() );
        ticket.setPrice( ticketDto.getPrice() );
        ticket.setFlag( ticketDto.getFlag() );

        return ticket;
    }
}
