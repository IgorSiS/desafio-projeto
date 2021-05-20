package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.response.CreateProjectResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("projects")
public interface GetAllProjectsApi {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<CreateProjectResponse> execute() throws UseCaseException;
}
