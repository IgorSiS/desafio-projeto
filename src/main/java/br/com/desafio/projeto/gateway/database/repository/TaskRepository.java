package br.com.desafio.projeto.gateway.database.repository;

import br.com.desafio.projeto.gateway.model.TaskDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskDatabase, String> {

    List<TaskDatabase> findByProjectId(String id);
}
