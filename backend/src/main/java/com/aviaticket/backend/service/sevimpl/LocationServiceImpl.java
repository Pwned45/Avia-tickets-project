package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.LocationMapper;
import com.aviaticket.backend.dto.LocationDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.models.Location;
import com.aviaticket.backend.repos.LocationRepository;
import com.aviaticket.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public LocationDto getLocationById(Long id) throws EntityNotFoundException {
        return locationMapper.toLocationDTO(locationRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<LocationDto> getAllLocation() {
        return locationMapper.toLocationDTOs(locationRepository.findAll().stream().
            sorted(Comparator.comparing(Location::getCity)).collect(Collectors.toList()));
    }
}
