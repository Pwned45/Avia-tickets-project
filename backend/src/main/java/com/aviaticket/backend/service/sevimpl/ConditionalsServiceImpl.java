package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.ConditionalsMapper;
import com.aviaticket.backend.dto.ConditionalsDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.repos.ConditionalsRepository;
import com.aviaticket.backend.service.ConditionalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionalsServiceImpl implements ConditionalsService {
    private final ConditionalsRepository conditionalsRepository;
    private final ConditionalsMapper conditionalsMapper;

    @Autowired
    public ConditionalsServiceImpl(ConditionalsRepository conditionalsRepository, ConditionalsMapper conditionalsMapper) {
        this.conditionalsRepository = conditionalsRepository;
        this.conditionalsMapper = conditionalsMapper;
    }

    @Override
    public List<ConditionalsDto> getAll() {
        return conditionalsMapper.toConditionalDTOs(conditionalsRepository.findAll());
    }

    @Override
    public ConditionalsDto getById(Long id) throws EntityNotFoundException {
        return conditionalsMapper.toConditionalDTO(conditionalsRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
