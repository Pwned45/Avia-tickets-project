package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.ParametrSerch;
import com.aviaticket.backend.dto.TicketDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;

import java.util.List;

public interface TicketService {
    List<TicketDto> findTicket(ParametrSerch parametrSerch);
    void update(TicketDto ticketDto) throws EntityNotFoundException;
    void save(TicketDto ticketDto);
    void delete(Long id);

}
