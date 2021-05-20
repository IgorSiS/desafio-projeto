package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.gateway.exception.GatewayException;

public interface DeleteTaskByIdGateway {
    void execute(final String id) throws GatewayException;
}
