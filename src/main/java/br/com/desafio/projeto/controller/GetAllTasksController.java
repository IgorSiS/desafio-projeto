package br.com.desafio.projeto.controller;

import br.com.desafio.projeto.api.GetAllTasksApi;
import br.com.desafio.projeto.api.response.GetAllTaskResponse;
import br.com.desafio.projeto.controller.translator.TaskListToTaskResponseListTranslator;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.usecase.GetAllTasksUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class GetAllTasksController implements GetAllTasksApi {

    @Autowired
    private final GetAllTasksUseCase getAllTasksUseCase;

    @Override
    public List<GetAllTaskResponse> execute() throws UseCaseException {

        log.info("Receiving data for get all tasks");

        List<Task> tasks = this.getAllTasksUseCase.execute();

        return TaskListToTaskResponseListTranslator.execute(tasks);
    }
}
