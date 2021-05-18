package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.GetProjectByIdGateway;
import br.com.desafio.projeto.gateway.database.repository.ProjectRepository;
import br.com.desafio.projeto.gateway.database.translator.ProjectDatabaseToProjectTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetProjectByIdDatabaseGateway implements GetProjectByIdGateway {

    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public Project execute(final String id) throws GatewayException {

        try {

            final Optional<ProjectDatabase> projectDatabase = this.projectRepository.findById(id);

            return projectDatabase.map(ProjectDatabaseToProjectTranslator::execute).orElse(null);

        }catch (Exception e){
            log.error("Error when try save task on database", e);
            throw new GatewayException("Error when try save task on database", e);
        }
    }
}
