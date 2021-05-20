package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.GetAllTaskResponse;
import br.com.desafio.projeto.domain.Task;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TaskListToTaskResponseListTranslator {

    public List<GetAllTaskResponse> execute(List<Task> tasks) {

        List<GetAllTaskResponse> list = new ArrayList<GetAllTaskResponse>(tasks.size());
        for (Task task : tasks) {
            list.add(taskToGetAllTaskResponse(task));
        }

        return list;
    }

    public GetAllTaskResponse taskToGetAllTaskResponse(Task task) {

        return GetAllTaskResponse.builder()
                .id(task.getId())
                .project_id(task.getProject().getId())
                .name(task.getName())
                .startDate(task.getStartDate())
                .endDate(task.getEndDate())
                .finish(task.getFinish())
                .build();
    }
}
