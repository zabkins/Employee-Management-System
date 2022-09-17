package pl.zarczynski.ems.Service;

import org.springframework.stereotype.Service;
import pl.zarczynski.ems.Repository.EmployeeRepository;
import pl.zarczynski.ems.domain.Employee;

import java.util.List;

@Service
public class DefaultEmployeeService implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public DefaultEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
