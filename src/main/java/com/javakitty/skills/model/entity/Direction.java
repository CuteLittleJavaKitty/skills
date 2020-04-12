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
@Builder
@Table(name = "directions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
