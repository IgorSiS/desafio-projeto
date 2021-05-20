package br.com.desafio.projeto.api;

import br.com.desafio.projeto.domain.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("task")
public interface DeleteTaskByIdApi {

    @DeleteMapping(path = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void execute(@PathVariable("id") final String id) throws UseCaseException;
}
