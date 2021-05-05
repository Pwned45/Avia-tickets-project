package com.aviaticket.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @Column(name = "id_seat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeat;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_plane", nullable = false)
    private Plane plane;

    @Column(name = "row")
    private Integer row;

    @Column(name = "number_seat")
    private Integer numberSeat;

}
