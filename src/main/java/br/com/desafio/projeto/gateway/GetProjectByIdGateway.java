package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.exception.GatewayException;

public interface GetProjectByIdGateway {
    Project execute(final String id) throws GatewayException;
}
