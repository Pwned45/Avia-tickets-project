package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.*;
import com.aviaticket.backend.exeption.EntityNotFoundException;

import java.text.ParseException;
import java.util.List;

public interface TicketService {
    List<TicketDto> getAllList();
    ResultTicketDto findTicket(ParametrSerch parametrSerch) throws ParseException;
    List<TicketDto> userOffer(Long id) throws EntityNotFoundException;
    void update(TicketDtoFront ticketDto) throws EntityNotFoundException, ParseException;
    void save(TicketDtoFront ticketDto) throws EntityNotFoundException, ParseException;
    void delete(Long id);
    TicketDto getTicketByID(Long id) throws EntityNotFoundException;


}
