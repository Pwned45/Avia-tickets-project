package com.aviaticket.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParametrSerch {
    private String dateS;
    private String end;
    private String cityStart;
    private String cityEnd;
}
