package br.com.desafio.projeto

import br.com.desafio.projeto.domain.Project
import br.com.desafio.projeto.domain.Task
import br.com.desafio.projeto.domain.exception.CreateTaskUseCaseException
import br.com.desafio.projeto.gateway.CreateTaskGateway
import br.com.desafio.projeto.gateway.GetProjectByIdGateway
import br.com.desafio.projeto.gateway.exception.GatewayException
import br.com.desafio.projeto.usecase.CreateTaskUseCase
import spock.lang.Specification

import java.time.LocalDate

class CreateTaskUseCaseSpec extends Specification {

    private final CreateTaskGateway createTaskGateway = Mock(CreateTaskGateway);
    private final GetProjectByIdGateway getProjectByIdGateway = Mock(GetProjectByIdGateway)
    private final CreateTaskUseCase createTaskUseCase = new CreateTaskUseCase(createTaskGateway,getProjectByIdGateway );

    def "It should create task with success"() {

        Task task = getTask();
        String project_id = "cdb89106-935a-45d0-9afb-9673c08271d0"

        when: "usecase is called"
        createTaskUseCase.execute(project_id,task)

        then: "should call gateway of creation project with success"
        1 * getProjectByIdGateway.execute(_ as String) >> {
            getProjectWithId()
        }

        then: "should call gateway with success"
        1 * createTaskGateway.execute(_ as Task) >> {
            getTaskWithId()
        }
    }


    def "Should throw an exception because it was not possible to create the task"() {
        Task task = getTask();
        String project_id = "cdb89106-935a-45d0-9afb-9673c08271d0"

        when: "usecase is called"
        createTaskUseCase.execute(project_id,task)

        then: "should call gateway of creation project with success"
        1 * getProjectByIdGateway.execute(_ as String) >> {
            getProjectWithId()
        }

        then: "should call gateway with exception"
        1 * createTaskGateway.execute(_ as Task) >> {
            throw new GatewayException("Error when try save task on database");
        }

        and: "Should be returned with exception"
        thrown(CreateTaskUseCaseException)
    }

    def getTaskWithId() {

        Project project = Project.builder()
                .id("cdb89106-935a-45d0-9afb-9673c08271d0")
                .build();

        Task task = Task.builder()
                .id("855e54ab-3e18-4bc4-81e2-3c017e7b3c66")
                .name("Projeto1")
                .project(project)
                .startDate(LocalDate.of(2019, 01, 06))
                .endDate(LocalDate.of(2019, 01, 15))
                .finish(true)
                .build()

        return task;
    }

    def getTask() {

        Project project = Project.builder()
                .id("cdb89106-935a-45d0-9afb-9673c08271d0")
                .build();

        Task task = Task.builder()
                .name("Projeto1")
                .project(project)
                .startDate(LocalDate.of(2019, 01, 06))
                .endDate(LocalDate.of(2019, 01, 15))
                .finish(true)
                .build()

        return task;
    }

    def getProjectWithId() {

        Project project = Project.builder()
                .id("cdb89106-935a-45d0-9afb-9673c08271d0")
                .name("Projeto1")
                .startDate(LocalDate.of(2019, 01, 01))
                .endDate(LocalDate.of(2019, 01, 31))
                .build()

        return project;
    }

}
