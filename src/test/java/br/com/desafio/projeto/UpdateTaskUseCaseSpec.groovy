package br.com.desafio.projeto

import br.com.desafio.projeto.domain.Project
import br.com.desafio.projeto.domain.Task
import br.com.desafio.projeto.domain.exception.GetProjectByIdUseCaseException
import br.com.desafio.projeto.domain.exception.UpdateTaskUseCaseException
import br.com.desafio.projeto.gateway.UpdateTaskGateway
import br.com.desafio.projeto.gateway.exception.GatewayException
import br.com.desafio.projeto.usecase.GetProjectByIdUseCase
import br.com.desafio.projeto.usecase.GetTaskByIdUseCase
import br.com.desafio.projeto.usecase.UpdateTaskUseCase
import spock.lang.Specification

import java.time.LocalDate

class UpdateTaskUseCaseSpec extends Specification {

    private final GetTaskByIdUseCase getTaskByIdUseCase = Mock(GetTaskByIdUseCase);
    private final UpdateTaskGateway updateTaskGateway = Mock(UpdateTaskGateway)
    private final GetProjectByIdUseCase getProjectByIdUseCase = Mock(GetProjectByIdUseCase)
    private final UpdateTaskUseCase updateTaskUseCase = new UpdateTaskUseCase(getTaskByIdUseCase,updateTaskGateway, getProjectByIdUseCase);

    def "It should update task with success"() {

        Task task = getTaskWithId();
        String task_id = "cdb89106-935a-45d0-9afb-9673c08271d0"

        when: "usecase is called"
        updateTaskUseCase.execute(task_id,task)

        then: "should call gateway of get task by id with success"
        1 * getTaskByIdUseCase.execute(_ as String) >> {
            getTaskWithId()
        }

        then: "should call gateway of get project by id with success"
        1 * getProjectByIdUseCase.execute(_ as String) >> {
            getProjectWithId()
        }

        then: "should call gateway with success"
        1 * updateTaskGateway.execute(_ as Task) >> {
            getTaskWithId()
        }
    }

    def "Must throw an exception because the task id was not found"() {
        Task task = getTask();
        String task_id = "cdb89106-935a-45d0-9afb-9673c08271d0"

        when: "usecase is called"
        updateTaskUseCase.execute(task_id,task)

        then: "should call gateway of get project by id with error"
        1 * getTaskByIdUseCase.execute(_ as String) >> {
            throw new UpdateTaskUseCaseException("Error get task by id");
        }

        then: "This gateway will not be called"
        0 * getProjectByIdUseCase.execute(_ as String)

        then: "should call gateway of update task with error"
        0 * updateTaskGateway.execute(_ as Task)

        and: "Should be returned with exception"
        thrown(UpdateTaskUseCaseException)
    }

    def "Must throw an exception because the project id was not found"() {
        Task task = getTask();
        String task_id = "cdb89106-935a-45d0-9afb-9673c08271d0"


        when: "usecase is called"
        updateTaskUseCase.execute(task_id,task)

        then: "should call gateway of get task by id with success"
        1 * getTaskByIdUseCase.execute(_ as String) >> {
            getTaskWithId()
        }

        then: "should call gateway of get project by id with error"
        1 * getProjectByIdUseCase.execute(_ as String) >> {
            throw new GetProjectByIdUseCaseException("project by id not found");
        }

        then: "should call gateway of update task with error"
        0 * updateTaskGateway.execute(_ as Task)

        and: "Should be returned with exception"
        thrown(GetProjectByIdUseCaseException)
    }

    def "Must throw an exception because the task don't update"() {
        Task task = getTask();
        String task_id = "cdb89106-935a-45d0-9afb-9673c08271d0"


        when: "usecase is called"
        updateTaskUseCase.execute(task_id,task)

        then: "should call gateway of get task by id with success"
        1 * getTaskByIdUseCase.execute(_ as String) >> {
            getTaskWithId()
        }

        then: "should call gateway of get project by id with error"
        1 * getProjectByIdUseCase.execute(_ as String) >> {
            getProjectWithId()
        }

        then: "should call gateway of update task with error"
        1 * updateTaskGateway.execute(_ as Task) >> {
            throw new GatewayException("Error when try update task on database");
        }

        and: "Should be returned with exception"
        thrown(UpdateTaskUseCaseException)
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
