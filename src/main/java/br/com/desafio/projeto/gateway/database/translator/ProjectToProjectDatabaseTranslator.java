package br.com.desafio.projeto.gateway.database.translator;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class ProjectToProjectDatabaseTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public ProjectDatabase translate(Project project) {

        return MAPPER.projectToProjectDatabase(project);
    }
}
