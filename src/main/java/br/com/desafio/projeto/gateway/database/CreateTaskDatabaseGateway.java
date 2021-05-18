package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.CreateTaskGateway;
import br.com.desafio.projeto.gateway.database.repository.TaskRepository;
import br.com.desafio.projeto.gateway.database.translator.TaskDatabaseToTaskTranslator;
import br.com.desafio.projeto.gateway.database.translator.TaskToTaskDatabaseTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateTaskDatabaseGateway implements CreateTaskGateway {

    @Autowired
    private final TaskRepository taskRepository;

    @Override
    public Task execute(Task task) throws GatewayException {

        try {

            final TaskDatabase taskDatabase =
                    this.taskRepository.save(TaskToTaskDatabaseTranslator.execute(task));

             return TaskDatabaseToTaskTranslator.execute(taskDatabase);

        }catch (Exception e){
            log.error("Error when try save task on database", e);
            throw new GatewayException("Error when try save task on database", e);
        }
    }
}
