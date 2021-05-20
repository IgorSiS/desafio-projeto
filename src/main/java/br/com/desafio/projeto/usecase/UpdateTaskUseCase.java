package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.CreateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UpdateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UpdateTaskUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.UpdateTaskGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateTaskUseCase {

    @Autowired
    private final GetTaskByIdUseCase getTaskByIdUseCase;

    @Autowired
    private final UpdateTaskGateway updateTaskGateway;

    @Autowired
    private final GetProjectByIdUseCase getProjectByIdUseCase;

    public Task execute(final String task_id, final Task task) throws UseCaseException {

        try {

            //Verifica se a task realmente existe, se não lança Exception
            this.getTaskByIdUseCase.execute(task_id);

            //Verifica se o projeto foi mudado, caso tenha sido, verificar se o projeto existe
            Project project = getProjectByIdUseCase.execute(task.getProject().getId());

            //Caso o id do projeto tenha mudado e ele existe, seta o novo id. Se não existir, lança a Exception
            task.setProject(project);

            return this.updateTaskGateway.execute(task);

        } catch (GatewayException e) {
            log.error("Error update task", e);
            throw new UpdateTaskUseCaseException("Error update task", e);
        }

    }
}
