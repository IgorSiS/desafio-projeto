package br.com.desafio.projeto.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {

    @JsonProperty(value = "nome")
    @NotEmpty(message = "O campo 'name' deve ser informado")
    private String name;

    @JsonProperty(value = "data_inicial")
    @NotEmpty(message = "O campo 'startDate' deve ser informado")
    private String startDate;

    @JsonProperty(value = "data_final")
    @NotEmpty(message = "O campo 'endDate' deve ser informado")
    private String endDate;

    @JsonProperty(value = "finalizada")
    @NotEmpty(message = "O campo 'finish' deve ser informado")
    private Boolean finish;

}
