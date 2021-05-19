package br.com.desafio.projeto.gateway.database.translator;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

import java.util.List;

@UtilityClass
public class TaskDatabaseListToTaskListTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public List<Task> execute(List<TaskDatabase> taskDatabase) {

        return MAPPER.taskDatabaseListToTaskList(taskDatabase);
    }
}
