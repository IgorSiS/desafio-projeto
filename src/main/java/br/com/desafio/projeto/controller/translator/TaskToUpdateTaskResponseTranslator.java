package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.UpdateTaskResponse;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class TaskToUpdateTaskResponseTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public UpdateTaskResponse execute(Task task) {

        UpdateTaskResponse updateTaskResponse = MAPPER.taskToUpdateTaskResponse(task);
        updateTaskResponse.setProject_id(task.getProject().getId());

        return updateTaskResponse;
    }
}
