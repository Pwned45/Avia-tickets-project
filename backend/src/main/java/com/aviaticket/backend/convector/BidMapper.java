package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.BidDto;
import com.aviaticket.backend.dto.LocationDto;
import com.aviaticket.backend.models.Bid;
import com.aviaticket.backend.models.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TicketMapper.class})
public interface BidMapper {

    BidDto toBidDTO(Bid bid);

    List<BidDto> toBidDTOs(List<Bid> bid);

    Bid toBid(BidDto bidDto);
}
