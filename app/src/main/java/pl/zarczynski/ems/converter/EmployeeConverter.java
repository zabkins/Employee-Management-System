package pl.zarczynski.ems.converter;

import org.springframework.core.convert.converter.Converter;
import pl.zarczynski.ems.domain.Employee;
import pl.zarczynski.ems.domain.EmployeeModel;

public class EmployeeConverter implements Converter<Employee, EmployeeModel> {
    @Override
    public EmployeeModel convert(Employee source) {
        return null;
    }
}
