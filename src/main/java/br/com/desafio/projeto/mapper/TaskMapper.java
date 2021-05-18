package br.com.desafio.projeto.mapper;

import br.com.desafio.projeto.api.request.TaskRequest;
import br.com.desafio.projeto.api.response.TaskResponse;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {

    Task taskRequestToTask(TaskRequest request);

    TaskResponse taskToTaskResponse(Task task);

    TaskDatabase taskToTaskDatabase(Task task);

    Task taskDatabaseToTask(TaskDatabase taskDatabase);
}
