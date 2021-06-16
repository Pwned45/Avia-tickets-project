package com.aviaticket.backend.dto;

import com.aviaticket.backend.models.Roles;
import com.aviaticket.backend.transfer.AdminDetails;
import com.aviaticket.backend.transfer.Details;
import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
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
public class UserDto {
    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})

    @JsonView({Details.class, AdminDetails.class})
    private Long idUser;

    @NotNull(groups = {New.class, Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private LocationDto locationDto;

    @Null(groups = {New.class})
    @JsonView({Details.class, AdminDetails.class})
    private Roles roles;

    @NotNull(groups = {New.class, Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private String name;

    @NotNull(groups = {New.class, Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private String lastName;

    @NotNull(groups = {New.class, Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Moscow")
    private Date bornDay;


    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private String login;

    @NotNull(groups = {New.class})
    @JsonView({AdminDetails.class})
    private String pass;

    @NotNull(groups = {New.class, Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private String email;

    @NotNull(groups = {New.class, Existing.class})
    @JsonView({Details.class, AdminDetails.class})
    private Long phone;

}
