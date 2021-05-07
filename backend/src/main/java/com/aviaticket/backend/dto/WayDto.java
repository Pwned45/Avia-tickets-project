package com.aviaticket.backend.dto;

import com.aviaticket.backend.models.Plane;
import com.aviaticket.backend.models.Point;
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
public class WayDto {
    @Null(groups = {New.class}, message = "The field must be empty")
    @NotNull(groups = {Existing.class})
    private Long idWay;

    @NotNull(groups = {New.class, Existing.class})
    private PointDto pointFirstDto;

    @NotNull(groups = {New.class, Existing.class})
    private PointDto pointEndDto;

    @NotNull(groups = {New.class, Existing.class})
    private PlaneDto planeDto;

    @NotNull(groups = {New.class, Existing.class})
    private Integer time;

}
