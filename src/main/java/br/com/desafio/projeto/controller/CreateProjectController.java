package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.CreateProjectApi;
import br.com.desafio.projeto.api.request.ProjectRequest;
import br.com.desafio.projeto.api.response.ProjectResponse;
import br.com.desafio.projeto.controller.translator.ProjectRequestToRequestTranslator;
import br.com.desafio.projeto.controller.translator.ProjectToProjectResponseTranslator;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.CreateProjectUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CreateProjectController implements CreateProjectApi {

    @Autowired
    private final CreateProjectUseCase createProjectUseCase;

    @Override
    public ProjectResponse execute(@Valid @RequestBody final ProjectRequest request) throws UseCaseException {

        log.info("Receiving data for project creation");

        Project project = this.createProjectUseCase.execute(ProjectRequestToRequestTranslator.execute(request));

        return ProjectToProjectResponseTranslator.execute(project);
    }
}
