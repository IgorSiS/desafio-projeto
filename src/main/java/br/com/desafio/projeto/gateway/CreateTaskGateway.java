package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.exception.GatewayException;

public interface CreateTaskGateway {
    Task execute(Task task) throws GatewayException;
}
