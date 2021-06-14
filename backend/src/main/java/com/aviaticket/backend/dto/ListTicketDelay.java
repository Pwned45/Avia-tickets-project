package com.aviaticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListTicketDelay {
    private List<TicketDto> ticketDtoList=new ArrayList<>();
    private Integer countOfDelay;
    private List<String> delay=new ArrayList<>();
}
