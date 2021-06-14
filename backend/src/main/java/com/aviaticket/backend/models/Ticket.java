package com.aviaticket.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long idTicket;

    @OneToOne
    @JoinColumn(name = "id_way", referencedColumnName = "id_way",nullable = false)
    private Way way;

    @OneToOne
    @JoinColumn(name = "id_seat", referencedColumnName = "id_seat")
    private Seat seat;

    @Column(name = "date_start")
    private Date startDate;

    @Column(name = "date_end")
    private Date endDate;

    @Column(name = "price")
    private Long price;

    @Column(name = "flag")
    private Integer flag;

    @OneToMany(mappedBy = "ticket", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<BidHasTicket> bidHasTickets = new ArrayList<>();

}
