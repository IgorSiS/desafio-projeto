package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.gateway.DeleteProjectByIdGateway;
import br.com.desafio.projeto.gateway.DeleteTaskByIdGateway;
import br.com.desafio.projeto.gateway.database.repository.ProjectRepository;
import br.com.desafio.projeto.gateway.database.repository.TaskRepository;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteTaskByIdDatabaseGateway implements DeleteTaskByIdGateway {

    @Autowired
    private final TaskRepository taskRepository;

    @Override
    public void execute(final String id) throws GatewayException {

        try {

            this.taskRepository.deleteById(id);

        }catch (Exception e){
            log.error("Error when try delete by task id on database", e);
            throw new GatewayException("Error when try delete task by id on database", e);
        }
    }
}
