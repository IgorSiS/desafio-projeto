package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.request.UpdateProjectRequest;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.mapper.TaskMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class UpdateProjectRequestToProjectTranslator {

    private final TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    public Project execute(UpdateProjectRequest request) {

       return MAPPER.updateProjectRequestToProject(request);
    }
}
