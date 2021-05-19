package br.com.desafio.projeto.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskRequest {

    @JsonProperty(value = "nome")
    @NotBlank(message = "O campo 'name' deve ser informado")
    private String name;


    @NotBlank(message = "O campo 'projectId' deve ser informado")
    @JsonProperty(value = "project_id")
    private String projectId;

    @JsonProperty(value = "data_inicial")
    @NotNull(message = "O campo 'startDate' deve ser informado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate  startDate;

    @JsonProperty(value = "data_final")
    @NotNull(message = "O campo 'endDate' deve ser informado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    @JsonProperty(value = "finalizada")
    @NotNull(message = "O campo 'finish' deve ser informado")
    private Boolean finish;

}
