package com.aviaticket.backend.dto;

import com.aviaticket.backend.models.Ticket;
import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BidDto {

    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idBid;

    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    private TicketDto ticketDto;

    @NotNull(groups = {New.class, Existing.class})
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Moscow")
    private Date date;

    @NotNull(groups = {New.class, Existing.class})
    private Long price;

}
