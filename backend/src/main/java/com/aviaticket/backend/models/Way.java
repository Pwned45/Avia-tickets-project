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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "point_first_id", referencedColumnName = "id_point")
    private Point pointFirst;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "point_end_id", referencedColumnName = "id_point")
    // @JoinColumn(name = "point_end", nullable = false)
    private Point pointEnd;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_plane", nullable = false)
    private Plane plane;

    @OneToOne(mappedBy = "way", orphanRemoval = true)
    private Ticket ticket;
}
