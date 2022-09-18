package pl.zarczynski.ems.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.zarczynski.ems.domain.Employee;
import pl.zarczynski.ems.domain.EmployeeModel;

@Component
public class EmployeeConverter implements Converter<Employee, EmployeeModel> {
    @Override
    public EmployeeModel convert(Employee employee) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employee.getId());
        employeeModel.setName(employee.getName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setHiredSince(employee.getHiredSince());
        employeeModel.setSalary(employee.getSalary());
        employeeModel.setPosition(employee.getPosition());
        return employeeModel;
    }

    public EmployeeModel convertToSimplified(Employee employee){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employee.getId());
        employeeModel.setName(employee.getName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setPosition(employee.getPosition());
        return employeeModel;
    }
}
