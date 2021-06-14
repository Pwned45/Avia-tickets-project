package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.dto.Choice;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.TicketNoAvailability;

public interface ChecksService {
    CheckDto getCheckById(Long id) throws EntityNotFoundException;
    void buyTicket(Choice choice) throws EntityNotFoundException, TicketNoAvailability;
}
