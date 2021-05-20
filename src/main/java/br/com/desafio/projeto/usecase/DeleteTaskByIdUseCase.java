package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.exception.DeleteTaskByIdUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.DeleteTaskByIdGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeleteTaskByIdUseCase {

    @Autowired
    private final DeleteTaskByIdGateway deleteTaskByIdGateway;

    @Autowired
    private final GetTaskByIdUseCase getTaskByIdUseCase;

    public void execute(final String id) throws UseCaseException{

        try{

            //Verificar se a task realmente existe
            this.getTaskByIdUseCase.execute(id);

            this.deleteTaskByIdGateway.execute(id);

        }catch (GatewayException e){
            log.error("Error delete task by id", e);
            throw new DeleteTaskByIdUseCaseException("Error delete task by id", e);
        }

    }
}
