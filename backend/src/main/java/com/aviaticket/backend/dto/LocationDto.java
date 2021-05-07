package com.aviaticket.backend.dto;

import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idLocation;

    @NotNull(groups = {New.class, Existing.class})
    private String country;

    @NotNull(groups = {New.class, Existing.class})
    private String city;
}
