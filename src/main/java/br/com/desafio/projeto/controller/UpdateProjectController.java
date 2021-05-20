package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.UpdateProjectApi;
import br.com.desafio.projeto.api.UpdateTaskApi;
import br.com.desafio.projeto.api.request.UpdateProjectRequest;
import br.com.desafio.projeto.api.request.UpdateTaskRequest;
import br.com.desafio.projeto.api.response.UpdateProjectResponse;
import br.com.desafio.projeto.api.response.UpdateTaskResponse;
import br.com.desafio.projeto.controller.translator.ProjectToUpdateProjectResponseTranslator;
import br.com.desafio.projeto.controller.translator.TaskToUpdateTaskResponseTranslator;
import br.com.desafio.projeto.controller.translator.UpdateProjectRequestToProjectTranslator;
import br.com.desafio.projeto.controller.translator.UpdateTaskRequestToTaskTranslator;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.UpdateProjectUseCase;
import br.com.desafio.projeto.usecase.UpdateTaskUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UpdateProjectController implements UpdateProjectApi {

    @Autowired
    private final UpdateProjectUseCase updateProjectUseCase;

    @Override
    public UpdateProjectResponse execute(@PathVariable final String project_id,
                                         @Valid @RequestBody final UpdateProjectRequest request) throws UseCaseException {

        log.info("Receiving data for project update");

        Project project = this.updateProjectUseCase.execute(project_id, UpdateProjectRequestToProjectTranslator.execute(request));

        return ProjectToUpdateProjectResponseTranslator.execute(project);
    }
}
