package pl.zarczynski.ems.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeModel {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate hiredSince;
    private Position position;
    private int salary;
}
