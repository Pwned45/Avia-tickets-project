package com.aviaticket.backend.dto;

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
public class CheckDto {
    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idChecks;

    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    private BidDto bidDto;

    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    private UserDto userDto;

    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    private String cardNumber;

    @NotNull(groups = {New.class, Existing.class})
    private String info;
}
