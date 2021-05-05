package com.aviaticket.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "id_location")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

//    @OneToMany(mappedBy = "locationend", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
//        orphanRemoval = true)
//    private List<Ticket> ticketsend = new ArrayList<>();

    @OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Way> ways = new ArrayList<>();
}
