package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.GetAllProjectsApi;
import br.com.desafio.projeto.api.response.CreateProjectResponse;
import br.com.desafio.projeto.controller.translator.ProjectListToProjectsResponseListTranslator;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.GetAllProjectsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class GetAllProjectsController implements GetAllProjectsApi {

    @Autowired
    private final GetAllProjectsUseCase getAllProjectsUseCase;

    @Override
    public List<CreateProjectResponse> execute() throws UseCaseException {

        log.info("Receiving data for get all project");

        List<Project> project = this.getAllProjectsUseCase.execute();

        return ProjectListToProjectsResponseListTranslator.execute(project);
    }
}
