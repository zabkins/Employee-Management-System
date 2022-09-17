package pl.zarczynski.ems.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.zarczynski.ems.Service.DefaultEmployeeService;
import pl.zarczynski.ems.Service.EmployeeService;
import pl.zarczynski.ems.domain.Employee;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(DefaultEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> listAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public Employee saveEmployee(){
        return null;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){

    }
}
