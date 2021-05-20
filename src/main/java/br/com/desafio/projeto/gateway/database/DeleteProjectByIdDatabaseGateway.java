package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.CreateProjectGateway;
import br.com.desafio.projeto.gateway.DeleteProjectByIdGateway;
import br.com.desafio.projeto.gateway.database.repository.ProjectRepository;
import br.com.desafio.projeto.gateway.database.translator.ProjectDatabaseToProjectTranslator;
import br.com.desafio.projeto.gateway.database.translator.ProjectToProjectDatabaseTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteProjectByIdDatabaseGateway implements DeleteProjectByIdGateway {

    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public void execute(final String id) throws GatewayException {

        try {

            this.projectRepository.deleteById(id);

        }catch (Exception e){
            log.error("Error when try delete by id on database", e);
            throw new GatewayException("Error when try delete by id on database", e);
        }
    }
}
