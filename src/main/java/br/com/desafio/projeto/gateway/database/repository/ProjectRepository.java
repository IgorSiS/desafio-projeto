package br.com.desafio.projeto.gateway.database.repository;

import br.com.desafio.projeto.gateway.model.ProjectDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectDatabase, String> {

}
