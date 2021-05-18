package br.com.desafio.projeto.gateway.database.translator;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class TaskToTaskDatabaseTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public TaskDatabase execute(Task task) {

        return MAPPER.taskToTaskDatabase(task);
    }
}
