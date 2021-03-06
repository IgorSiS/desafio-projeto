package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.request.CreateProjectRequest;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class ProjectRequestToRequestTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public Project execute(CreateProjectRequest request) {

        return MAPPER.projectRequestToRequest(request);
    }
}
