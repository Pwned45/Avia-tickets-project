package com.aviaticket.backend.dto;

import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idTicket;

    @NotNull(groups = {New.class, Existing.class})
    private WayDto wayDto;

    @NotNull(groups = {New.class, Existing.class})
    private SeatDto seatDto;

    @NotNull(groups = {New.class, Existing.class})
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Moscow")
    private Date startDate;

    @NotNull(groups = {New.class, Existing.class})
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Moscow")
    private Date endDate;

    @NotNull(groups = {New.class, Existing.class})
    private Long price;

    @NotNull(groups = {New.class, Existing.class})
    private Integer flag;


}
