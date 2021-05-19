package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.UpdateTaskApi;
import br.com.desafio.projeto.api.request.UpdateTaskRequest;
import br.com.desafio.projeto.api.response.UpdateTaskResponse;
import br.com.desafio.projeto.controller.translator.TaskToCreateTaskResponseTranslator;
import br.com.desafio.projeto.controller.translator.TaskToUpdateTaskResponseTranslator;
import br.com.desafio.projeto.controller.translator.UpdateTaskRequestToTaskTranslator;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.CreateTaskUseCase;
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
public class UpdateTaskController implements UpdateTaskApi {

    @Autowired
    private final UpdateTaskUseCase updateTaskUseCase;

    @Override
    public UpdateTaskResponse execute(@PathVariable final String task_id,
                                      @Valid @RequestBody final UpdateTaskRequest request) throws UseCaseException {

        log.info("Receiving data for task update");

        Task task = this.updateTaskUseCase.execute(task_id, UpdateTaskRequestToTaskTranslator.execute(request));

        return TaskToUpdateTaskResponseTranslator.execute(task);
    }
}
