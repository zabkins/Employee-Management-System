package pl.zarczynski.ems.data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.zarczynski.ems.Repository.EmployeeRepository;
import pl.zarczynski.ems.domain.Employee;
import pl.zarczynski.ems.domain.Position;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements InitializingBean {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        createInitialDatabaseData();
    }

    private void createInitialDatabaseData() {
        List<Employee> employees = List.of(
                new Employee("usr1", passwordEncoder.encode("pass1"), "John", "Smith",
                        LocalDate.of(2022, 1, 1), Position.MANAGER, 140000),
                new Employee("usr2",passwordEncoder.encode("pass2"),"Andrew","Marks",
                        LocalDate.of(2021,4,1),Position.ENGINEER,85000),
                new Employee("usr3", passwordEncoder.encode("pass3"),"Amanda","Stones",
                        LocalDate.of(2019,6,1),Position.ENGINEER,94000),
                new Employee("usr4", passwordEncoder.encode("pass4"),"Katrina","Rose",
                        LocalDate.of(2021,7,1),Position.SALES,75000),
                new Employee("usr5", passwordEncoder.encode("pass5"),"Teddy","Kraft",
                        LocalDate.of(2020,2,1),Position.ASSEMBLER,62000),
                new Employee("usr6", passwordEncoder.encode("pass6"),"Thomas","Wozniak",
                        LocalDate.of(2019,3,1),Position.ACCOUNTANT,65000)
        );
        employeeRepository.saveAll(employees);
    }
}
