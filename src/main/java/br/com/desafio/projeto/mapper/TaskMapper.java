package br.com.desafio.projeto.mapper;

import br.com.desafio.projeto.api.request.CreateTaskRequest;
import br.com.desafio.projeto.api.request.UpdateProjectRequest;
import br.com.desafio.projeto.api.request.UpdateTaskRequest;
import br.com.desafio.projeto.api.response.CreateTaskResponse;
import br.com.desafio.projeto.api.response.GetAllTaskResponse;
import br.com.desafio.projeto.api.response.UpdateTaskResponse;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TaskMapper {

    Task taskRequestToTask(CreateTaskRequest request);

    CreateTaskResponse taskToCreateTaskResponse(Task task);

    TaskDatabase taskToTaskDatabase(Task task);

    Task taskDatabaseToTask(TaskDatabase taskDatabase);

    List<Task> taskDatabaseListToTaskList(List<TaskDatabase> taskDatabase);

    Task updateTaskRequestToTask(UpdateTaskRequest request);

    UpdateTaskResponse taskToUpdateTaskResponse(Task task);

    List<GetAllTaskResponse> taskListToTaskResponseList(List<Task> tasks);

    Project updateProjectRequestToProject(UpdateProjectRequest request);
}
