package com.aviaticket.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "point")
public class Point {
    @Id
    @Column(name = "id_point")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPoint;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_location", nullable = false)
    private Location location;

    @Column(name = "id_route")
    private Long idRoute;

    @Column(name = "airport")
    private String airport;

    @Column(name = "number")
    private Integer number;

    @OneToOne(mappedBy = "pointFirst")
    private Way wayStart;

    @OneToOne(mappedBy = "pointEnd")
    private Way wayEnd;

//    @OneToMany(mappedBy = "pointFirst", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
//        orphanRemoval = true)
//    private List<Way> waysone = new ArrayList<>();
//    @OneToMany(mappedBy = "pointEnd", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
//        orphanRemoval = true)
//    private List<Way> waystwo = new ArrayList<>();

}
