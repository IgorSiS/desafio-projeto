package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.request.TaskRequest;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;


@UtilityClass
public class TaskRequestToTaskTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public Task execute(String projectId, TaskRequest request) {
         Task task = MAPPER.taskRequestToTask(request);
         task.setProjectId(projectId);
        return task;
    }
}
