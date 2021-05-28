package com.aviaticket.backend.dto;

import lombok.Data;

import java.util.List;
@Data
public class ResultTicketDto {
    private List<List<TicketDto>> result;
}
