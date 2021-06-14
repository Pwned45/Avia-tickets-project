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
@Table(name = "additionalcondit")
public class Additional {
    @Id
    @Column(name = "id_add_con")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddCond;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_adc", nullable = false)
    private Conditionals conditionals;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_bid", nullable = false)
    private Bid bid;
}
