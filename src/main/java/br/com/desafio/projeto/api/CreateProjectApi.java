package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.request.CreateProjectRequest;
import br.com.desafio.projeto.api.response.ProjectResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RequestMapping("project")
public interface CreateProjectApi {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    ProjectResponse execute(@Valid @RequestBody final CreateProjectRequest request) throws UseCaseException;
}
