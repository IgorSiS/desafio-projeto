package br.com.desafio.projeto.mapper;

import br.com.desafio.projeto.api.request.CreateProjectRequest;
import br.com.desafio.projeto.api.response.ProgressProjectResponse;
import br.com.desafio.projeto.api.response.ProjectResponse;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    Project projectRequestToRequest(CreateProjectRequest request);

    ProjectResponse projectToProjectResponse(Project project);

    ProjectDatabase projectToProjectDatabase(Project project);

    Project projectDatabaseToProject(ProjectDatabase projectDatabase);

    ProgressProjectResponse projectToProgressProjectResponse(Project project);
}
