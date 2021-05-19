package br.com.desafio.projeto.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    private String id;

    private String name;

    private LocalDate startDate;

    private LocalDate  endDate;

    private String percentComplete;

    private Boolean delayed;

    private List<Task> tasks;
}
