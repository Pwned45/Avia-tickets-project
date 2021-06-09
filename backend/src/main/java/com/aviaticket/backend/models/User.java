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
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_location", nullable = false)
    private Location location;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Column(name = "user_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born_date")
    private Date bornDay;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_pass")
    private String pass;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_telephone")
    private Long phone;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true)
    private List<Checks> checks = new ArrayList<>();
}
