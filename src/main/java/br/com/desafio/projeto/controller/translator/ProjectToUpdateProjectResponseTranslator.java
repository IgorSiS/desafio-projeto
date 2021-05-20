package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.UpdateProjectResponse;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class ProjectToUpdateProjectResponseTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public UpdateProjectResponse execute(Project project) {
        return MAPPER.projectToUpdateProjectResponse(project);
    }
}
