package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.models.Checks;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T22:14:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ChecksMapperImpl implements ChecksMapper {

    @Autowired
    private BidMapper bidMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public CheckDto toCheckDTO(Checks checks) {
        if ( checks == null ) {
            return null;
        }

        CheckDto checkDto = new CheckDto();

        checkDto.setUserDto( userMapper.toUserDTO( checks.getUser() ) );
        checkDto.setBidDto( bidMapper.toBidDTO( checks.getBid() ) );
        checkDto.setIdChecks( checks.getIdChecks() );
        checkDto.setCardNumber( checks.getCardNumber() );
        checkDto.setInfo( checks.getInfo() );

        return checkDto;
    }

    @Override
    public List<CheckDto> toCheckDTOs(List<Checks> checksList) {
        if ( checksList == null ) {
            return null;
        }

        List<CheckDto> list = new ArrayList<CheckDto>( checksList.size() );
        for ( Checks checks : checksList ) {
            list.add( toCheckDTO( checks ) );
        }

        return list;
    }

    @Override
    public Checks toCheck(CheckDto checksDto) {
        if ( checksDto == null ) {
            return null;
        }

        Checks checks = new Checks();

        checks.setUser( userMapper.toUser( checksDto.getUserDto() ) );
        checks.setBid( bidMapper.toBid( checksDto.getBidDto() ) );
        checks.setIdChecks( checksDto.getIdChecks() );
        checks.setCardNumber( checksDto.getCardNumber() );
        checks.setInfo( checksDto.getInfo() );

        return checks;
    }
}
