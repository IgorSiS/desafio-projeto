package br.com.desafio.projeto.gateway.model;

import br.com.desafio.projeto.domain.Task;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project")
@EqualsAndHashCode(of = {"id"})
public class ProjectDatabase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    //ADICIONAR NO CONTEXTO DE PERSISTENCIA

//    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//    private Set<TaskDatabase> tasks;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
