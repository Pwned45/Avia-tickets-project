package com.aviaticket.backend.dto;

import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDtoFront {
    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idTicket;

    @NotNull(groups = {New.class, Existing.class})
    private WayDto wayDto;

    @NotNull(groups = {New.class, Existing.class})
    private SeatDto seatDto;

    @NotNull(groups = {New.class, Existing.class})

    private String startDate;

    @NotNull(groups = {New.class, Existing.class})

    private String endDate;

    @NotNull(groups = {New.class, Existing.class})
    private Long price;

    @NotNull(groups = {New.class, Existing.class})
    private Integer flag;


}
