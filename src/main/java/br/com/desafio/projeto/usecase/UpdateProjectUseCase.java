package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.UpdateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.UpdateProjectGateway;
import br.com.desafio.projeto.gateway.UpdateTaskGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateProjectUseCase {

    @Autowired
    private final GetProjectByIdUseCase getProjectByIdUseCase;

    @Autowired
    private final UpdateProjectGateway updateTaskGateway;

    public Project execute(final String project_id, final Project project) throws UseCaseException {

        try {

            //Verificar se esse projeto realmente existe
            this.getProjectByIdUseCase.execute(project_id);

            return this.updateTaskGateway.execute(project);

        } catch (GatewayException e) {
            log.error("Error update project", e);
            throw new UpdateProjectUseCaseException("Error update project", e);
        }

    }
}
