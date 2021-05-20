package br.com.desafio.projeto.mapper;

import br.com.desafio.projeto.api.request.CreateProjectRequest;
import br.com.desafio.projeto.api.response.CreateProjectResponse;
import br.com.desafio.projeto.api.response.ProgressProjectResponse;
import br.com.desafio.projeto.api.response.UpdateProjectResponse;
import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

    Project projectRequestToRequest(CreateProjectRequest request);

    CreateProjectResponse projectToCreateProjectResponse(Project project);

    ProjectDatabase projectToProjectDatabase(Project project);

    Project projectDatabaseToProject(ProjectDatabase projectDatabase);

    ProgressProjectResponse projectToProgressProjectResponse(Project project);

    List<Project> projectDatabaseListToProjectList(List<ProjectDatabase> projectDatabase);

    List<CreateProjectResponse> ProjectListToProjectResponseList(List<Project> project);

    UpdateProjectResponse projectToUpdateProjectResponse(Project project);
}
