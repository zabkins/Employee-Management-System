package pl.zarczynski.ems.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zarczynski.ems.Service.DefaultEmployeeService;
import pl.zarczynski.ems.Service.EmployeeService;
import pl.zarczynski.ems.domain.Employee;

import java.util.List;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(DefaultEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> listAllEmployees(){
        return employeeService.getAll();
    }
}
