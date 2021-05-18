package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.exception.GatewayException;

public interface CreateProjectGateway {
    Project execute(Project project) throws GatewayException;
}
