package br.com.desafio.projeto.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    private String id;

    private String name;

    private String startDate;

    private String endDate;
}
