package com.aviaticket.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParametrSerch {
    //TODO:test
    private Date start;
    private Date end;
    private String cityStart;
    private String cityEnd;
}
