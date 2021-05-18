package br.com.desafio.projeto.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest {

    @JsonProperty(value = "nome")
    @NotEmpty(message = "O campo 'name' deve ser informado")
    private String name;

    @JsonProperty(value = "data_inicial")
    @NotEmpty(message = "O campo 'startDate' deve ser informado")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String startDate;

    @JsonProperty(value = "data_final")
    @NotEmpty(message = "O campo 'endDate' deve ser informado")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String endDate;
}
