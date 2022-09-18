package pl.zarczynski.ems.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class NewEmployee {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private Position position;
    private int salary;
}
