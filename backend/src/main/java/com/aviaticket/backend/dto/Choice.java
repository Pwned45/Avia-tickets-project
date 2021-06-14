package com.aviaticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private List<Long> idTickets = new ArrayList<>();
    private List<Long> conditionals = new ArrayList<>();
    private Long userDtoId;
    private String card_number;
    private String info;
}
