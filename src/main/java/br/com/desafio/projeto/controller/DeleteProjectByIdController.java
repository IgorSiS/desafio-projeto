package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.DeleteProjectByIdApi;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.DeleteProjectByIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DeleteProjectByIdController implements DeleteProjectByIdApi {

    @Autowired
    private final DeleteProjectByIdUseCase deleteProjectByIdUseCase;

    @Override
    public void execute(final String id) throws UseCaseException {

        log.info("Receiving data for delete project");

        this.deleteProjectByIdUseCase.execute(id);
    }
}
