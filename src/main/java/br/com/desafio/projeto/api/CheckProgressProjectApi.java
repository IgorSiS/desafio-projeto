package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.response.ProgressProjectResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("project")
public interface CheckProgressProjectApi {

    @GetMapping(path = "/check/progress/{projectId}")
    @ResponseStatus(value = HttpStatus.OK)
    ProgressProjectResponse execute(@PathVariable("projectId") final String projectId ) throws UseCaseException;
}
