package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.request.CreateTaskRequest;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;


@UtilityClass
public class CreateTaskRequestToTaskTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public Task execute(CreateTaskRequest request) {

        return MAPPER.taskRequestToTask(request);
    }
}
