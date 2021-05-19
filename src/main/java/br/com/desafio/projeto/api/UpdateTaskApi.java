package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.request.UpdateTaskRequest;
import br.com.desafio.projeto.api.response.UpdateTaskResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("task")
public interface UpdateTaskApi {

    @PutMapping(path = "/{task_id}")
    @ResponseStatus(value = HttpStatus.OK)
    UpdateTaskResponse execute(@PathVariable("task_id") final String  task_id,
                               @Valid @RequestBody final UpdateTaskRequest request) throws UseCaseException;
}
