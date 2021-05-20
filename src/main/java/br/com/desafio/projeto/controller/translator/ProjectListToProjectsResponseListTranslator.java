package br.com.desafio.projeto.controller.translator;

import br.com.desafio.projeto.api.response.CreateProjectResponse;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.mapper.ProjectMapper;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

import java.util.List;

@UtilityClass
public class ProjectListToProjectsResponseListTranslator {

    private final ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    public List<CreateProjectResponse> execute(List<Project> project) {

        return MAPPER.ProjectListToProjectResponseList(project);
    }
}
