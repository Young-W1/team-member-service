package com.etz.teamcrud.model;

import com.etz.teamcrud.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    //@Column(name= "status")
    private Status status;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects project;

    public void setTeam(Team teamx) {
    }
}


//Models are also known as Entities