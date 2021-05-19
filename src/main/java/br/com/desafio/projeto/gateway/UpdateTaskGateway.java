package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.exception.GatewayException;

public interface UpdateTaskGateway {
    Task execute(final Task task) throws GatewayException;
}
