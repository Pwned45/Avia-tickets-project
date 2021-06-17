package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.WayDto;
import java.util.List;

public interface WayServise {
    List<WayDto> getAvailWay();
}
