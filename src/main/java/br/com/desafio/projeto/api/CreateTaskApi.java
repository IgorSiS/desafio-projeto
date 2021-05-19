package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.request.CreateTaskRequest;
import br.com.desafio.projeto.api.response.CreateTaskResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("task")
public interface CreateTaskApi {

    @PostMapping(path = "/{project_id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    CreateTaskResponse execute(@PathVariable("project_id") final String  projectId,
                               @Valid @RequestBody final CreateTaskRequest request) throws UseCaseException;
}
