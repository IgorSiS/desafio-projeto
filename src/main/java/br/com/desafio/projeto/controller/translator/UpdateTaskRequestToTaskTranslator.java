package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.request.UpdateTaskRequest;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;


@UtilityClass
public class UpdateTaskRequestToTaskTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public Task execute(UpdateTaskRequest request) {

        Task task = MAPPER.updateTaskRequestToTask(request);

        Project project = Project.builder()
                 .id(request.getProjectId())
                 .build();

        task.setProject(project);

        return task;
    }
}
