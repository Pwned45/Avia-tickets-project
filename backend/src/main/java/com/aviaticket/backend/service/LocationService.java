package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.LocationDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;

import java.util.List;

public interface LocationService {
    LocationDto getLocationById(Long id) throws EntityNotFoundException;
    List<LocationDto> getAllLocation();
}
