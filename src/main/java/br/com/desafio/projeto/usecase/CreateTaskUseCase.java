package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.CreateTaskUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.CreateTaskGateway;
import br.com.desafio.projeto.gateway.GetProjectByIdGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateTaskUseCase {

    @Autowired
    private final CreateTaskGateway createTaskGateway;

    @Autowired
    private final GetProjectByIdGateway getProjectByIdGateway;


    public Task execute(final String project_id, final Task task) throws UseCaseException{

        try{

          Project project = this.getProjectByIdGateway.execute(project_id);

            task.setProject(project);

            return this.createTaskGateway.execute(task);

        }catch (GatewayException e){
            log.error("Error create task", e);
            throw new CreateTaskUseCaseException("Error create task", e);
        }

    }
}
