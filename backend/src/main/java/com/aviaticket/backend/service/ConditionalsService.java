package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.ConditionalsDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;

import java.util.List;

public interface ConditionalsService {
    List<ConditionalsDto> getAll();

    ConditionalsDto getById(Long id) throws EntityNotFoundException;
}
