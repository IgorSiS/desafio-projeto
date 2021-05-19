package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.CheckProgressProjectApi;
import br.com.desafio.projeto.api.response.ProgressProjectResponse;
import br.com.desafio.projeto.controller.translator.ProjectToProgressProjectResponseTranslator;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.CheckProgressProjectUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CheckProgressProjectController implements CheckProgressProjectApi {

    @Autowired
    private final CheckProgressProjectUseCase checkProgressProjectUseCase;

    @Override
    public ProgressProjectResponse execute(@PathVariable final String projectId) throws UseCaseException {

        log.info("Receiving data for check progress project");

        Project project = this.checkProgressProjectUseCase.execute(projectId);

        return ProjectToProgressProjectResponseTranslator.execute(project);
    }
}
