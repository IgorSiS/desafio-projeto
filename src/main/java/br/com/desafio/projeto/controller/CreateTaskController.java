package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.CreateTaskApi;
import br.com.desafio.projeto.api.request.TaskRequest;
import br.com.desafio.projeto.api.response.TaskResponse;
import br.com.desafio.projeto.controller.translator.TaskRequestToTaskTranslator;
import br.com.desafio.projeto.controller.translator.TaskToTaskResponseTranslator;
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
    public TaskResponse execute(@PathVariable final String projectId,
                                @Valid @RequestBody final TaskRequest request) throws UseCaseException {

        log.info("Receiving data for task creation");

        Task task = this.createTaskUseCase.execute(TaskRequestToTaskTranslator.execute(projectId,request));

        return TaskToTaskResponseTranslator.execute(task);
    }
}
