package com.aviaticket.backend.dto;

import com.aviaticket.backend.transfer.AdminDetails;
import com.aviaticket.backend.transfer.Details;
import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import com.fasterxml.jackson.annotation.JsonView;
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
public class LocationDto {

    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private Long idLocation;

    @JsonView({Details.class, AdminDetails.class})
    @NotNull(groups = {New.class, Existing.class})
    private String country;

    @JsonView({Details.class, AdminDetails.class})
    @NotNull(groups = {New.class, Existing.class})
    private String city;
}
