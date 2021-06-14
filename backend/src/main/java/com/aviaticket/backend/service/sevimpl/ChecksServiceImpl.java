package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.ChecksMapper;
import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.dto.Choice;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.TicketNoAvailability;
import com.aviaticket.backend.models.*;
import com.aviaticket.backend.repos.*;
import com.aviaticket.backend.service.ChecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChecksServiceImpl implements ChecksService {
    private final ChecksRepository checksRepository;
    private final ChecksMapper checksMapper;
    private final BidRepository bidRepository;
    private final TicketRepository ticketRepository;
    ;
    private final UserRepository userRepository;
    private final ConditionalsRepository conditionalsRepository;

    @Autowired
    public ChecksServiceImpl(ChecksRepository checksRepository, ChecksMapper checksMapper, BidRepository bidRepository, TicketRepository ticketRepository, UserRepository userRepository, ConditionalsRepository conditionalsRepository) {
        this.checksRepository = checksRepository;
        this.checksMapper = checksMapper;
        this.bidRepository = bidRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.conditionalsRepository = conditionalsRepository;
    }

    @Override
    public CheckDto getCheckById(Long id) throws EntityNotFoundException {
        return checksMapper.toCheckDTO(checksRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void buyTicket(Choice choice) throws EntityNotFoundException, TicketNoAvailability {
        Bid bid = new Bid();
        Checks check = new Checks();
        List<Ticket> tickets = new ArrayList<>();
        choice.getIdTickets().forEach(x -> {
            try {
                tickets.add(ticketRepository.findById(x).orElseThrow(EntityNotFoundException::new));
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
        });
        Long priceT = 0L;
        tickets.sort(Comparator.comparing(Ticket::getFlag));
        for (Ticket ticket : tickets) {
            if (ticket.getFlag() > 0) {
          //      bid.setBidHasTickets(Collections.singletonList(new BidHasTicket(null, ticket, bid)));
               bid.getBidHasTickets().add(new BidHasTicket(null, ticket, bid));
                ticket.setFlag(ticket.getFlag() - 1);
                priceT += ticket.getPrice();

            } else {
                throw new TicketNoAvailability();
            }
        }
        if (choice.getConditionals().size() > 0) {
            List<Conditionals> conditionals = new ArrayList<>();
            for (Long id : choice.getConditionals()) {
                conditionals.add(conditionalsRepository.findById(id).orElseThrow(EntityNotFoundException::new));
            }
            for (Conditionals con : conditionals) {
                bid.getAdditionalServces().add(new Additional(null, con, bid));
                priceT += con.getPrice();
            }
        }
        bid.setPrice(priceT);
        bid.setDate(new Date());
        check.setCardNumber(choice.getCard_number());
        if (choice.getInfo() != null) {
            check.setInfo(choice.getInfo());
        }
        check.setBid(bid);
        check.setUser(userRepository.findById(choice.getUserDtoId()).
            orElseThrow(() -> new EntityNotFoundException(choice.getUserDtoId(), "Users")));
        checksRepository.save(check);

    }
}
