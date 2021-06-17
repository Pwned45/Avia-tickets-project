package com.aviaticket.backend.rest;

import com.aviaticket.backend.dto.*;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.TicketNoAvailability;
import com.aviaticket.backend.exeption.UserException;
import com.aviaticket.backend.service.ChecksService;
import com.aviaticket.backend.service.TicketService;
import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketsRestController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ChecksService checksService;

    @GetMapping(value = "/ticketsAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TicketDto>> getAllTickets() throws ParseException {
        List<TicketDto> res = ticketService.getAllList();
        if (!res.isEmpty()) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultTicketDto> getTickets(@RequestBody ParametrSerch parametrSerch) throws ParseException {
        ResultTicketDto res = ticketService.findTicket(parametrSerch);
        if (parametrSerch == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!res.getResult().isEmpty()) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('USER')or hasAuthority('ADMIN')")
    @PostMapping(value = "/buy", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buyTicket(@RequestBody Choice choice) throws ParseException, EntityNotFoundException, TicketNoAvailability {
        if (choice == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            checksService.buyTicket(choice);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority('USER')or hasAuthority('ADMIN')")
    @GetMapping(value = "{id}/uniqe", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TicketDto>> getUniqe(@PathVariable("id") Long id) throws EntityNotFoundException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ticketService.userOffer(id);
        return new ResponseEntity<>(ticketService.userOffer(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patchTicket(@RequestBody TicketDtoFront ticketDto) throws DataIntegrityViolationException, EntityNotFoundException, UserException, ParseException {

        if (ticketDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ticketService.update(ticketDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) throws EntityNotFoundException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ticketService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "")
    public ResponseEntity<?> saveTicket(@Validated(New.class) @RequestBody TicketDtoFront ticketDtoFront) throws EntityNotFoundException, ParseException, IOException {
        if (ticketDtoFront == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            ticketService.save(ticketDtoFront);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDto> getTicketByID(@PathVariable("id") Long id) throws EntityNotFoundException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ticketService.getTicketByID(id);
        return new ResponseEntity<>(ticketService.getTicketByID(id), HttpStatus.OK);
    }
}
