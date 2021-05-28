package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.ChecksMapper;
import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.repos.ChecksRepository;
import com.aviaticket.backend.service.ChecksService;

public class ChecksServiceImpl implements ChecksService {
    private final ChecksRepository checksRepository;
    private final ChecksMapper checksMapper;

    public ChecksServiceImpl(ChecksRepository checksRepository, ChecksMapper checksMapper) {
        this.checksRepository = checksRepository;
        this.checksMapper = checksMapper;
    }

    @Override
    public CheckDto getCheckById(Long id) throws EntityNotFoundException {
        return checksMapper.toCheckDTO(checksRepository.findById(id).orElseThrow(EntityNotFoundException::new)) ;
    }
}
