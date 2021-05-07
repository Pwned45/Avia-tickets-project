package com.aviaticket.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "way")
public class Way {
    @Id
    @Column(name = "id_way")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWay;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "point_start", nullable = false)
    private Point pointFirst;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "point_end", nullable = false)
    private Point pointEnd;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_plane", nullable = false)
    private Plane plane;

    @Column(name = "time")
    private Integer time;

    @OneToMany(mappedBy = "way", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();
}
