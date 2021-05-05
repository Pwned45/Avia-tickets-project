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
@Table(name = "conditionals")
public class Conditionals {
    @Id
    @Column(name = "id_adc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdc;

    @Column(name = "title")
    private String title;

    @Column(name = "info")
    private String info;

    @Column(name = "price")
    private Long price;

    @OneToMany(mappedBy = "conditionals", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Additional> additionalServces = new ArrayList<>();
}
