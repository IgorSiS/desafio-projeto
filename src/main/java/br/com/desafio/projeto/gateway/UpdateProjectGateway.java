package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.gateway.exception.GatewayException;

public interface UpdateProjectGateway {
    Project execute(final Project project) throws GatewayException;
}
