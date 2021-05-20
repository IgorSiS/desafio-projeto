package br.com.desafio.projeto

import br.com.desafio.projeto.domain.Project
import br.com.desafio.projeto.domain.exception.CreateProjectUseCaseException
import br.com.desafio.projeto.gateway.CreateProjectGateway
import br.com.desafio.projeto.gateway.exception.GatewayException
import br.com.desafio.projeto.usecase.CreateProjectUseCase
import spock.lang.Specification

import java.time.LocalDate

class CreateProjectUseCaseSpec extends Specification {

    private final CreateProjectGateway createProjectGateway = Mock(CreateProjectGateway);
    private final CreateProjectUseCase createProjectUseCase = new CreateProjectUseCase(createProjectGateway);


    def "It should create project with success"() {
        Project project = getProject();

        when: "usecase is called"
        createProjectUseCase.execute(project)

        then: "should call gateway with success"
        1 * createProjectGateway.execute(_ as Project) >> {
            getProjectWithId()
        }
    }

    def "It should not create the project and launch a gateway gateway exception"() {
        Project project = getProject();

        when: "usecase is called"
        createProjectUseCase.execute(project)

        then: "should call gateway with success"
        1 * createProjectGateway.execute(_ as Project) >> {
            throw new GatewayException("Error when try save on database");
        }

        and: "Should be returned with exception"
        thrown(CreateProjectUseCaseException)
    }

    def getProject() {

        Project project = Project.builder()
                .name("Projeto1")
                .startDate(LocalDate.of(2019, 01, 01))
                .endDate(LocalDate.of(2019, 01, 31))
                .build()

        return project;
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
