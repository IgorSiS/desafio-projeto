package br.com.desafio.projeto.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private String id;

    private Project project;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean finish;

}
