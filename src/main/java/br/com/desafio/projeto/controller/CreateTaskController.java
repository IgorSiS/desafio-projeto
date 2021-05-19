package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.CreateTaskApi;
import br.com.desafio.projeto.api.request.CreateTaskRequest;
import br.com.desafio.projeto.api.response.CreateTaskResponse;
import br.com.desafio.projeto.controller.translator.CreateTaskRequestToTaskTranslator;
import br.com.desafio.projeto.controller.translator.TaskToCreateTaskResponseTranslator;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.CreateTaskUseCase;
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
public class CreateTaskController implements CreateTaskApi {

    @Autowired
    private final CreateTaskUseCase createTaskUseCase;

    @Override
    public CreateTaskResponse execute(@PathVariable final String project_id,
                                      @Valid @RequestBody final CreateTaskRequest request) throws UseCaseException {

        log.info("Receiving data for task creation");

        Task task = this.createTaskUseCase.execute(project_id, CreateTaskRequestToTaskTranslator.execute(request));

        return TaskToCreateTaskResponseTranslator.execute(task);
    }
}
