package br.com.desafio.projeto.gateway.database.translator;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class ProjectDatabaseToProjectTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public Project execute(ProjectDatabase projectDatabase) {

        return MAPPER.projectDatabaseToProject(projectDatabase);
    }
}
