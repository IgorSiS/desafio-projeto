package br.com.desafio.projeto.gateway.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    private String name;

    private LocalDate startDate;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true, mappedBy = "project")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TaskDatabase> task;

    private LocalDate  endDate;
}
