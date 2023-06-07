package com.example.spring_boot_templete.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sample")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data", nullable = false)
    private String data;

    @Column(name = "created_dt", nullable = false)
    private LocalDateTime createdDt;
}
