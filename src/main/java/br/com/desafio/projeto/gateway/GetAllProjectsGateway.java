package br.com.desafio.projeto.gateway;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.exception.GatewayException;

import java.util.List;

public interface GetAllProjectsGateway {
    List<Project> execute() throws GatewayException;
}
