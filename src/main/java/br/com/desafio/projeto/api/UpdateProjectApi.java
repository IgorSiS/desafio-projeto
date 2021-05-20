package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.request.UpdateProjectRequest;
import br.com.desafio.projeto.api.response.UpdateProjectResponse;
import br.com.desafio.projeto.api.response.UpdateTaskResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("project")
public interface UpdateProjectApi {

    @PutMapping(path = "/{project_id}")
    @ResponseStatus(value = HttpStatus.OK)
    UpdateProjectResponse execute(@PathVariable("project_id") final String  project_id,
                                  @Valid @RequestBody final UpdateProjectRequest request) throws UseCaseException;
}
