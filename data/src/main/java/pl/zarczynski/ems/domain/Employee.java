package pl.zarczynski.ems.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Employee {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private LocalDateTime hiredSince;
    private Position position;
    private int salary;
}
