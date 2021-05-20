package br.com.desafio.projeto.api;

import br.com.desafio.projeto.api.response.GetAllTaskResponse;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("tasks")
public interface GetAllTasksApi {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<GetAllTaskResponse> execute() throws UseCaseException;
}
