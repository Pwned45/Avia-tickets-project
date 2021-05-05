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
@Table(name = "checks")
public class Checks {
    @Id
    @Column(name = "id_checks")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChecks;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_bid", nullable = false)
    private Bid bid;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "card_number")
    private String cardNumber;//TODO:надо обсудить

    @Column(name = "info")
    private String info;
}
