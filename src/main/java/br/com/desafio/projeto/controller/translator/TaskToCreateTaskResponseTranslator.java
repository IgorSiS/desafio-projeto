package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.CreateTaskResponse;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class TaskToCreateTaskResponseTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public CreateTaskResponse execute(Task task) {

        CreateTaskResponse createTaskResponse = MAPPER.taskToCreateTaskResponse(task);
        createTaskResponse.setProject_id(task.getProject().getId());

        return createTaskResponse;
    }
}
