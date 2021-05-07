package com.aviaticket.backend.dto;

import com.aviaticket.backend.models.Ticket;
import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {

    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idSeat;

//    @NotNull(groups = {New.class, Existing.class})
//    private TicketDto ticketDto;

    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    private PlaneDto planeDto;

    @NotNull(groups = {New.class, Existing.class})
    private Integer row;

    @NotNull(groups = {New.class, Existing.class})
    private Integer numberSeat;

}
