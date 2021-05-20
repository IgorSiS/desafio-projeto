package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.GetAllProjectsGateway;
import br.com.desafio.projeto.gateway.database.repository.ProjectRepository;
import br.com.desafio.projeto.gateway.database.translator.ProjectDatabaseListToProjectListTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetAllProjectsDatabaseGateway implements GetAllProjectsGateway {

    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> execute() throws GatewayException {

        try {

            List<ProjectDatabase> projectDatabase = this.projectRepository.findAll();

             return ProjectDatabaseListToProjectListTranslator.execute(projectDatabase);

        }catch (Exception e){
            log.error("Error when try get all project on database", e);
            throw new GatewayException("Error when try get all project on database", e);
        }
    }
}
