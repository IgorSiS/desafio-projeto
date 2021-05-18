package br.com.desafio.projeto.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private String id;

    private String projectId;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Boolean finish;

}
