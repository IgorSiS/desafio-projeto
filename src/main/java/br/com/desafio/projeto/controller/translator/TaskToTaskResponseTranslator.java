package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.TaskResponse;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class TaskToTaskResponseTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public TaskResponse execute(Task task) {

        return MAPPER.taskToTaskResponse(task);
    }
}
