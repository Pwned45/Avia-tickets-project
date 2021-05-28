package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;

public interface ChecksService {
    CheckDto getCheckById(Long id) throws EntityNotFoundException;
}
