package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.exception.CreateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.GetProjectByIdUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.CreateProjectGateway;
import br.com.desafio.projeto.gateway.database.GetProjectByIdDatabaseGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GetProjectByIdUseCase {

    @Autowired
    private final GetProjectByIdDatabaseGateway getProjectByIdDatabaseGateway;

    public Project execute(final String id) throws UseCaseException{

        try{

            return this.getProjectByIdDatabaseGateway.execute(id);

        }catch (GatewayException e){
            log.error("project not found", e);
            throw new GetProjectByIdUseCaseException("project by id not found", e);
        }

    }
}
