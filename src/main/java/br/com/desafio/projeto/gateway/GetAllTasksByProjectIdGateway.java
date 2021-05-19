package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.exception.GatewayException;

import java.util.List;

public interface GetAllTasksByProjectIdGateway {
    List<Task> execute(final String id) throws GatewayException;
}
