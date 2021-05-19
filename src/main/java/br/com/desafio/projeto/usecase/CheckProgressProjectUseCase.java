package br.com.desafio.projeto.usecase;

import br.com.desafio.projeto.domain.Project;
import br.com.desafio.projeto.domain.Task;
import br.com.desafio.projeto.domain.exception.CreateProjectUseCaseException;
import br.com.desafio.projeto.domain.exception.UseCaseException;
import br.com.desafio.projeto.gateway.GetAllTasksByProjectIdGateway;
import br.com.desafio.projeto.gateway.exception.GatewayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckProgressProjectUseCase {

    @Autowired
    private final GetProjectByIdUseCase getProjectByIdUseCase;

    @Autowired
    private final GetAllTasksByProjectIdGateway GetAllTasksByProjectIdGateway;

    public Project execute(final String id) throws UseCaseException{

        try{

            Project project = this.getProjectByIdUseCase.execute(id);

            final List<Task> tasks = this.GetAllTasksByProjectIdGateway.execute(project.getId());

            if(tasks.isEmpty()){
                log.error("Error check progress project. Project don't have task");
                throw new CreateProjectUseCaseException("Error check progress project. Project don't have task");
            }

            int allTasks = tasks.size();
            final int tasksFinished = Math.toIntExact(tasks.stream().filter(task -> task.getFinish().equals(true)).count());
            final double percentOfTasksFinished =  (double) ((double) tasksFinished / ( (double) allTasks) * 100);

            LocalDate maxEndDateTask = tasks.stream().map(Task::getEndDate).max(LocalDate::compareTo).get();
            LocalDate endDateProject = project.getEndDate();

            int differenceDate = maxEndDateTask.compareTo(endDateProject);
            boolean delayed;
            delayed = differenceDate > 0;

            project.setDelayed(delayed);
            project.setPercentComplete(String.valueOf(percentOfTasksFinished) + "%");
            project.setTasks(tasks);

            return project;

        }catch (GatewayException e){
            log.error("Error check progress project. Project don't have task", e);
            throw new CreateProjectUseCaseException("EError check progress project. Project don't have task", e);
        }

    }
}
