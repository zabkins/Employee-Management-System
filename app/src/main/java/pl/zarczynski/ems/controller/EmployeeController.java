package pl.zarczynski.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.zarczynski.ems.Service.DefaultEmployeeService;
import pl.zarczynski.ems.Service.EmployeeService;
import pl.zarczynski.ems.converter.EmployeeConverter;
import pl.zarczynski.ems.converter.NewEmployeeConverter;
import pl.zarczynski.ems.domain.Employee;
import pl.zarczynski.ems.domain.EmployeeModel;
import pl.zarczynski.ems.domain.NewEmployee;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;
    private final NewEmployeeConverter newEmployeeConverter;

    public EmployeeController(DefaultEmployeeService employeeService, EmployeeConverter employeeConverter, NewEmployeeConverter newEmployeeConverter) {
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
        this.newEmployeeConverter = newEmployeeConverter;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> listAllEmployees(){
        List<Employee> allEmployees = employeeService.getAll();
        List<EmployeeModel> employeeModels = allEmployees.stream()
                .map(employeeConverter::convert)
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeConverter.convert(employee),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody NewEmployee newEmployee){
        if(!SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
        }
        if(newEmployeeContainsNullValues(newEmployee)){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        Employee employee = newEmployeeConverter.convert(newEmployee);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeConverter.convert(savedEmployee),HttpStatus.OK);
    }

    private boolean newEmployeeContainsNullValues(NewEmployee newEmployee) {
        if(newEmployee.getName() == null || newEmployee.getLastName() == null || newEmployee.getUsername() == null ||
        newEmployee.getPassword() == null || newEmployee.getSalary() <= 0 || newEmployee.getPosition() == null){
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        if(!SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
