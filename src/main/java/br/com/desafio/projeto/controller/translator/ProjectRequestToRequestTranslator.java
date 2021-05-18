package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.request.ProjectRequest;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class ProjectRequestToRequestTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public Project execute(ProjectRequest request) {

        return MAPPER.projectRequestToRequest(request);
    }
}
