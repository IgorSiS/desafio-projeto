package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.exception.DeleteProjectByIdUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.DeleteProjectByIdGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeleteProjectByIdUseCase {

    @Autowired
    private final DeleteProjectByIdGateway deleteProjectByIdGateway;

    @Autowired
    private final GetProjectByIdUseCase getProjectByIdUseCase;


    public void execute(final String id) throws UseCaseException{

        try{

            //Verificar se o projeto realmente existe
            this.getProjectByIdUseCase.execute(id);

            this.deleteProjectByIdGateway.execute(id);

        }catch (GatewayException e){
            log.error("Error delete project by id", e);
            throw new DeleteProjectByIdUseCaseException("Error delete project by id", e);
        }

    }
}
