package com.aviaticket.backend.dto;

import com.aviaticket.backend.models.Location;
import com.aviaticket.backend.transfer.Existing;
import com.aviaticket.backend.transfer.New;
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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {

    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idPoint;

    @NotNull(groups = {New.class})
    @Null(groups = {Existing.class})
    private LocationDto locationDto;

    @NotNull(groups = {New.class, Existing.class})
    private Long idRoute;

    @NotNull(groups = {New.class, Existing.class})
    private String airport;

    @NotNull(groups = {New.class, Existing.class})
    private Integer number;
}
