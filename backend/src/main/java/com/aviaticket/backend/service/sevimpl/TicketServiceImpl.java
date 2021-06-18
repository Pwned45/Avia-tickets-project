package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.TicketMapper;
import com.aviaticket.backend.dto.*;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.models.Point;
import com.aviaticket.backend.models.Ticket;
import com.aviaticket.backend.models.User;
import com.aviaticket.backend.repos.*;
import com.aviaticket.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final PointRepository pointRepository;
    private final TicketMapper ticketMapper;
    private final UserRepository userRepository;
    private final WayRepository wayRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, SeatRepository seatRepository, PointRepository pointRepository, TicketMapper ticketMapper, UserRepository userRepository, WayRepository wayRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.pointRepository = pointRepository;
        this.ticketMapper = ticketMapper;
        this.userRepository = userRepository;
        this.wayRepository = wayRepository;
    }

    @Override
    public List<TicketDto> getAllList() {
        return ticketMapper.toTicketDTOs(ticketRepository.findAll());
    }

    @Override
    public ResultTicketDto findTicket(ParametrSerch parametrSerch) throws ParseException {
        List<Ticket> resTicket = new ArrayList<>();
        List<List<Ticket>> ticketList = new ArrayList<>();
        ResultTicketDto resultTicketDto = new ResultTicketDto();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tarS = format.parse(parametrSerch.getDateS());
        Point startP;
        boolean exit = true;
        List<Point> pointsStartCity = pointRepository.findPoint(parametrSerch.getCityStart(), parametrSerch.getCityEnd());
        for (int i = 0; i < pointsStartCity.size(); i++) {
            startP = pointsStartCity.get(i);
            while (exit) {
                if (!startP.getWayStart().getPointEnd().getLocation().getCity().equals(parametrSerch.getCityEnd())) {
                    if (startP.getWayStart().getTicket().getFlag() > 0) {
                        resTicket.add(startP.getWayStart().getTicket());
                        startP = startP.getWayStart().getPointEnd();
                    } else {
                        resTicket.clear();
                        break;
                    }
                } else {
                    if (startP.getWayStart().getTicket() != null) {
                        if (startP.getWayStart().getTicket().getFlag() > 0) {
                            resTicket.add(startP.getWayStart().getTicket());
                            exit = false;
                        } else {
                            resTicket.clear();
                            break;
                        }
                    }else {
                        resTicket.clear();
                        break;
                    }
                }
            }
            if (!resTicket.isEmpty()) {
                resTicket.stream().sorted(Comparator.comparing(a -> a.getWay().getIdWay())).collect(Collectors.toList());
                Date sourS = format.parse(resTicket.get(0).getStartDate().toString());
                if (sourS.equals(tarS)) {
                    ticketList.add(customAdd(resTicket));
                    resTicket.clear();
                } else {
                    resTicket.clear();
                }
            }
            exit = true;
        }
        if (!ticketList.isEmpty()) {
            for (int i = 0; i < ticketList.size(); i++) {
                resultTicketDto.getResult().add(convert((ticketList.get(i))));
            }
        }
        return resultTicketDto;
    }

    @Override
    public List<TicketDto> userOffer(Long id) throws EntityNotFoundException {
        List<TicketDto> ticketDtos = new ArrayList<>();
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Users"));
        List<Point> points = pointRepository.findPoint(user.getLocation().getCity());
        if (points.isEmpty()) {
            return ticketDtos;
        } else {
            for (Point point : points) {
                if (point.getWayStart() != null && point.getWayStart().getTicket()!=null) {
                    if (point.getWayStart().getTicket().getFlag() > 0) {
                        ticketDtos.add(ticketMapper.toTicketDTO(point.getWayStart().getTicket()));
                    }
                }
            }
        }
        return ticketDtos;
    }

    public List<Ticket> customAdd(List<Ticket> list) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.addAll(list);
        return tickets;
    }

    public ListTicketDelay convert(List<Ticket> lists) throws ParseException {

        ListTicketDelay listTicketDelay = new ListTicketDelay();
        if (lists.size() > 1) {
            listTicketDelay.setCountOfDelay(lists.size() - 1);
        } else {
            listTicketDelay.setCountOfDelay(0);
        }
        String s = "";
        int j = 0;
        for (int i = 0; i < lists.size(); i++) {
            j = i + 1;
            if (lists.size() > 1 && j != lists.size()) {
                int d = (int) ((lists.get(j).getStartDate().getTime() - lists.get(i).getEndDate().getTime()) / 86400000);
                int h = (int) (((lists.get(j).getStartDate().getTime() - lists.get(i).getEndDate().getTime()) % 86400000) / 3600000);
                int m = (int) (((lists.get(j).getStartDate().getTime() - lists.get(i).getEndDate().getTime()) % 3600000) / 60000);
                s = String.format("%d:%d:%d", d, h, m);
                listTicketDelay.getDelay().add(s);
                s = "";
            }
        }
        listTicketDelay.getTicketDtoList().addAll(ticketMapper.toTicketDTOs(lists));
        return listTicketDelay;
    }

    @Override
    public void update(TicketDtoFront ticketDto) throws EntityNotFoundException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Ticket ticketUpdate = ticketRepository.findById(ticketDto.getIdTicket()).orElseThrow(EntityNotFoundException::new);
        ticketUpdate.setStartDate(format.parse(ticketDto.getStartDate()));
        ticketUpdate.setEndDate(format.parse(ticketDto.getEndDate()));
        if (ticketDto.getPrice() > 0) {
            ticketUpdate.setPrice(ticketDto.getPrice());
        }
        if (ticketDto.getSeatDto().getIdSeat() > 0) {
            ticketUpdate.setSeat(seatRepository.findById(ticketDto.getSeatDto().getIdSeat()).orElseThrow(EntityNotFoundException::new));
        }
        ticketRepository.save(ticketUpdate);
    }

    @Override
    public void save(TicketDtoFront ticketDto) throws EntityNotFoundException, ParseException {
        Ticket ticket = new Ticket();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ticket.setSeat(seatRepository.findById(ticketDto.getSeatDto().getIdSeat()).orElseThrow(() ->
            new EntityNotFoundException(ticketDto.getSeatDto().getIdSeat(), "Seat")));
        ticket.setWay(wayRepository.findById(ticketDto.getWayDto().getIdWay()).orElseThrow(() ->
            new EntityNotFoundException(ticketDto.getWayDto().getIdWay(), "Way")));
        ticket.setFlag(ticketDto.getFlag());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setStartDate(format.parse(ticketDto.getStartDate()));
        ticket.setEndDate(format.parse(ticketDto.getEndDate()));
        ticket.setPrice(ticketDto.getPrice());
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDto getTicketByID(Long id) throws EntityNotFoundException {
        Ticket t = ticketRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ticketMapper.toTicketDTO(ticketRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
