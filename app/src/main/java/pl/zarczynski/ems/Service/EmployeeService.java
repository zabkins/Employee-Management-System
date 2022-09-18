package pl.zarczynski.ems.Service;

import pl.zarczynski.ems.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee findById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteById(Long id);

    Employee updateEmployee(Employee employee);
}
