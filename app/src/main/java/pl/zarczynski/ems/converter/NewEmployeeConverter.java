package pl.zarczynski.ems.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.zarczynski.ems.domain.Employee;
import pl.zarczynski.ems.domain.NewEmployee;
@Component
public class NewEmployeeConverter implements Converter<NewEmployee, Employee> {
    @Override
    public Employee convert(NewEmployee newEmployee) {
        Employee employee = new Employee();
        employee.setName(newEmployee.getName());
        employee.setLastName(newEmployee.getLastName());
        employee.setUsername(newEmployee.getUsername());
        employee.setPassword(newEmployee.getPassword());
        employee.setPosition(newEmployee.getPosition());
        employee.setSalary(newEmployee.getSalary());
        return employee;
    }
}
