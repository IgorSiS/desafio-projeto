package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.GetTaskByIdGateway;
import br.com.desafio.projeto.gateway.database.repository.TaskRepository;
import br.com.desafio.projeto.gateway.database.translator.TaskDatabaseToTaskTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.TaskDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetTaskByIdDatabaseGateway implements GetTaskByIdGateway {

    @Autowired
    private final TaskRepository taskRepository;

    @Override
    public Task execute(final String id) throws GatewayException {

        try {

            final Optional<TaskDatabase> taskDatabase = this.taskRepository.findById(id);

            return taskDatabase.map(TaskDatabaseToTaskTranslator::execute).orElseThrow(() -> new GatewayException("Task not found"));

        }catch (Exception e){
            log.error("Error when try get task by id on database", e);
            throw new GatewayException("Error when try get task by id on database", e);
        }
    }
}
