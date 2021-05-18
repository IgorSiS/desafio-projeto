package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.exception.CreateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.CreateProjectGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateProjectUseCase {

    @Autowired
    private final CreateProjectGateway createProjectGateway;

    public Project execute(final Project project) throws UseCaseException{

        try{

            return this.createProjectGateway.execute(project);

        }catch (GatewayException e){
            log.error("Error create project", e);
            throw new CreateProjectUseCaseException("Error create project", e);
        }

    }
}
