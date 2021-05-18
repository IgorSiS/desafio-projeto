package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.ProjectResponse;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class ProjectToProjectResponseTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public ProjectResponse execute(Project project) {

        return MAPPER.projectToProjectResponse(project);
    }
}
