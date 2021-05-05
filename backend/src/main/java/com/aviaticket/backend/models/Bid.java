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
@Table(name = "bid")
public class Bid {
    @Id
    @Column(name = "id_bid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBid;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_tiket", nullable = false)
    private Ticket ticket;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private Long price;

    @OneToMany(mappedBy = "bid", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<AdditionalServce> additionalServces = new ArrayList<>();
}
