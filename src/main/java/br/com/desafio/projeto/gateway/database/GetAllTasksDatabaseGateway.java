package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.GetAllTasksGateway;
import br.com.desafio.projeto.gateway.database.repository.TaskRepository;
import br.com.desafio.projeto.gateway.database.translator.TaskDatabaseListToTaskListTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetAllTasksDatabaseGateway implements GetAllTasksGateway {

    @Autowired
    private final TaskRepository taskRepository;

    @Override
    public List<Task> execute() throws GatewayException {

        try {

            List<TaskDatabase> taskDatabases = this.taskRepository.findAll();

             return TaskDatabaseListToTaskListTranslator.execute(taskDatabases);

        }catch (Exception e){
            log.error("Error when try get all tasks on database", e);
            throw new GatewayException("Error when try get all tasks on database", e);
        }
    }
}
