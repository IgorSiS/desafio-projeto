package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.request.TaskRequest;
import br.com.desafio.projeto.api.response.TaskResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("task")
public interface CreateTaskApi {

    @PostMapping(path = "/{projectId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    TaskResponse execute(@PathVariable("projectId") final String  projectId,
                         @Valid @RequestBody final TaskRequest request) throws UseCaseException;
}
