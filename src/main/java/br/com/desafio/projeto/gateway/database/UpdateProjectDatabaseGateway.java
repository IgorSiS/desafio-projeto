package br.com.desafio.projeto.gateway.database;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.UpdateProjectGateway;
import br.com.desafio.projeto.gateway.database.repository.ProjectRepository;
import br.com.desafio.projeto.gateway.database.translator.ProjectDatabaseToProjectTranslator;
import br.com.desafio.projeto.gateway.database.translator.ProjectToProjectDatabaseTranslator;
import br.com.desafio.projeto.gateway.database.translator.TaskDatabaseToTaskTranslator;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateProjectDatabaseGateway implements UpdateProjectGateway {

    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public Project execute(Project project) throws GatewayException {

        try {

            final ProjectDatabase projectDatabase =
                    this.projectRepository.save(ProjectToProjectDatabaseTranslator.execute(project));

             return ProjectDatabaseToProjectTranslator.execute(projectDatabase);

        }catch (Exception e){
            log.error("Error when try update project on database", e);
            throw new GatewayException("Error when try update project on database", e);
        }
    }
}
