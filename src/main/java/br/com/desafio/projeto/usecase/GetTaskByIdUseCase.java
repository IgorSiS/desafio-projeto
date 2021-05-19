package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.CreateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.GetTaskByIdGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GetTaskByIdUseCase {

    @Autowired
    private final GetTaskByIdGateway getTaskByIdGateway;

    public Task execute(final String id) throws UseCaseException{

        try{

            return this.getTaskByIdGateway.execute(id);

        }catch (GatewayException e){
            log.error("Error get task by id", e);
            throw new CreateProjectUseCaseException("Error get task by id", e);
        }

    }
}
