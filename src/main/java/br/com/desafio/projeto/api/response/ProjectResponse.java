package br.com.desafio.projeto.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String startDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String endDate;
}
