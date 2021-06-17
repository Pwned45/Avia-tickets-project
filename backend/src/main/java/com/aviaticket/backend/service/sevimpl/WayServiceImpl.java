package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.WayMapper;
import com.aviaticket.backend.dto.WayDto;
import com.aviaticket.backend.models.Way;
import com.aviaticket.backend.repos.WayRepository;
import com.aviaticket.backend.service.WayServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WayServiceImpl implements WayServise {
    private final WayRepository wayRepository;
    private final WayMapper wayMapper;

    @Autowired
    public WayServiceImpl(WayRepository wayRepository, WayMapper wayMapper) {
        this.wayRepository = wayRepository;
        this.wayMapper = wayMapper;
    }

    @Override
    public List<WayDto> getAvailWay() {
        List<Way> wayies = wayRepository.findAll();
        List<Way> res = new ArrayList<>();
        for (Way way : wayies) {
            if (way.getTicket() == null) {
                res.add(way);
            }
        }
        return wayMapper.toWayDTOs(res);
    }
}
