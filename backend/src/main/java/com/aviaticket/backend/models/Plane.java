package com.aviaticket.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @Column(name = "plane_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlane;

    @Column(name = "count_row")
    private Integer countRow;

    @Column(name = "count_seat")
    private Integer countSeat;

    @Column(name = "info")
    private String info;

    @OneToMany(mappedBy = "plane", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Way> way = new ArrayList<>();

    @OneToMany(mappedBy = "plane", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();

}
