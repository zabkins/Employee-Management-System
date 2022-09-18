package pl.zarczynski.ems.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private LocalDate hiredSince;
    @Enumerated(EnumType.STRING)
    private Position position;
    private int salary;

    public Employee(String login, String password, String name, String lastName, LocalDate hiredSince, Position position, int salary) {
        this.username = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.hiredSince = hiredSince;
        this.position = position;
        this.salary = salary;
    }
}
