package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.exception.GetAllProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.GetAllProjectsGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class GetAllProjectsUseCase {

    @Autowired
    private final GetAllProjectsGateway getAllProjectsGateway;

    public List<Project> execute() throws UseCaseException{

        try{

            return this.getAllProjectsGateway.execute();

        }catch (GatewayException e){
            log.error("Error get all projects", e);
            throw new GetAllProjectUseCaseException("Error get all projects", e);
        }

    }
}
