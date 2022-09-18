package pl.zarczynski.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zarczynski.ems.Service.DefaultEmployeeService;
import pl.zarczynski.ems.Service.EmployeeService;
import pl.zarczynski.ems.domain.Employee;
import pl.zarczynski.ems.domain.EmployeeModel;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(DefaultEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> listAllEmployees(){
        return null;
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
