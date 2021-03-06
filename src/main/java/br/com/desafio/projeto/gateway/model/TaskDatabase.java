package br.com.desafio.projeto.gateway.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "task")
@EqualsAndHashCode(of = {"id"})
public class TaskDatabase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectDatabase project;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean finish;
}
