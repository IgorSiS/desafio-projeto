package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.GetAllProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.GetAllTasksGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class GetAllTasksUseCase {

    @Autowired
    private final GetAllTasksGateway getAllTasksGateway;

    public List<Task> execute() throws UseCaseException{

        try{

            return this.getAllTasksGateway.execute();

        }catch (GatewayException e){
            log.error("Error get all tasks", e);
            throw new GetAllProjectUseCaseException("Error get all tasks", e);
        }

    }
}
