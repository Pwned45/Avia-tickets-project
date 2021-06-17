package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.BidDto;
import com.aviaticket.backend.models.Bid;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T22:28:28+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class BidMapperImpl implements BidMapper {

    @Override
    public BidDto toBidDTO(Bid bid) {
        if ( bid == null ) {
            return null;
        }

        BidDto bidDto = new BidDto();

        bidDto.setIdBid( bid.getIdBid() );
        bidDto.setDate( bid.getDate() );
        bidDto.setPrice( bid.getPrice() );

        return bidDto;
    }

    @Override
    public List<BidDto> toBidDTOs(List<Bid> bid) {
        if ( bid == null ) {
            return null;
        }

        List<BidDto> list = new ArrayList<BidDto>( bid.size() );
        for ( Bid bid1 : bid ) {
            list.add( toBidDTO( bid1 ) );
        }

        return list;
    }

    @Override
    public Bid toBid(BidDto bidDto) {
        if ( bidDto == null ) {
            return null;
        }

        Bid bid = new Bid();

        bid.setIdBid( bidDto.getIdBid() );
        bid.setDate( bidDto.getDate() );
        bid.setPrice( bidDto.getPrice() );

        return bid;
    }
}
