package com.etz.teamcrud.model;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

}
