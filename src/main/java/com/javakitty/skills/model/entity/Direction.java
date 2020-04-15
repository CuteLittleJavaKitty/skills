package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.DirectionGrade;
import com.javakitty.skills.model.DirectionTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "directions")
@AllArgsConstructor
@NoArgsConstructor
public class Direction {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "direction_id_seq")
    @SequenceGenerator(name = "direction_id_seq", sequenceName = "direction_id_seq", allocationSize = 1)
    Long id;

    @Column(name = "direction_title")
    private DirectionTitle directionTitle;

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade;

    @Column(name = "start_working_timestamp")
    private LocalDateTime startWorkingDate;

    @Column(name = "end_working_timestamp")
    private LocalDateTime endWorkingDate;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
