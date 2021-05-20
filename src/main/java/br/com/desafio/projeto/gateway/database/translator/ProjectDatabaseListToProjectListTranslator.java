package br.com.desafio.projeto.gateway.database.translator;


import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

import java.util.List;

@UtilityClass
public class ProjectDatabaseListToProjectListTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public List<Project> execute(List<ProjectDatabase> projectDatabase) {

       return MAPPER.projectDatabaseListToProjectList(projectDatabase);
    }
}
