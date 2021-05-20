package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.DeleteTaskByIdApi;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.DeleteProjectByIdUseCase;
import br.com.desafio.projeto.usecase.DeleteTaskByIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DeleteTaskByIdController implements DeleteTaskByIdApi {

    @Autowired
    private final DeleteTaskByIdUseCase deleteTaskByIdUseCase;

    @Override
    public void execute(final String id) throws UseCaseException {

        log.info("Receiving data for delete task");

        this.deleteTaskByIdUseCase.execute(id);
    }
}
