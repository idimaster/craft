package employee.controller;

import com.datastax.driver.core.utils.UUIDs;
import employee.controller.dto.Employee;
import employee.controller.dto.EmployeeUpdate;
import employee.controller.mapping.EmployeeMapping;
import employee.controller.mapping.EmployeeUpdateMapping;
import employee.domain.EmployeeData;
import employee.repository.EmployeeRepository;
import employee.repository.EmployeeUpdateRepository;
import employee.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by idimaster on 5/18/17.
 */
@RestController
public class EmployeeHrController {
    private static final String NO_EMPLOYER = "No Employer found for ID ";
    private static final String NO_EMPLOYEE = "No Employee found for ID ";

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeUpdateRepository employeeUpdateRepository;

    @GetMapping("/employee/employees/{employerId}")
    public List<Employee> employeesByEmployer(@PathVariable("employerId") UUID employerId) {
        return employeeRepository.findByEmployer(employerId)
                .map(EmployeeMapping::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity employees(@PathVariable("id") UUID id) {
        MapId mid = new BasicMapId().with("id", id);
        return Optional.ofNullable(employeeRepository.findOne(mid))
                .map(EmployeeMapping::toDto)
                .map(emp -> new ResponseEntity(emp, HttpStatus.OK))
                .orElse(new ResponseEntity(NO_EMPLOYEE + id, HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employee.setId(UUIDs.timeBased());
        MapId mid = new BasicMapId().with("id", employee.getEmployerId());
        if (!employerRepository.exists(mid)) {
            new ResponseEntity(NO_EMPLOYER + employee.getEmployerId(), HttpStatus.NOT_FOUND);
        }
        EmployeeData data = employeeRepository.insert(EmployeeMapping.fromDto(employee));
        return new ResponseEntity(EmployeeMapping.toDto(data), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable UUID id) {
        MapId mid = new BasicMapId().with("id", id);
        if (!employeeRepository.exists(mid)) {
            new ResponseEntity(NO_EMPLOYEE + id, HttpStatus.NOT_FOUND);
        }
        employeeRepository.delete(mid);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable UUID id, @RequestBody Employee employee) {
        MapId mid = new BasicMapId().with("id", id);
        if (!employeeRepository.exists(mid)) {
            new ResponseEntity(NO_EMPLOYEE + id, HttpStatus.NOT_FOUND);
        }
        employee.setId(id);
        EmployeeData data = employeeRepository.save(EmployeeMapping.fromDto(employee));
        return new ResponseEntity(EmployeeMapping.toDto(data), HttpStatus.OK);
    }

    @GetMapping("/employees/update/{id}")
    public List<EmployeeUpdate> employeesUpdate(@PathVariable("id") UUID id) {
        return employeeUpdateRepository.findByEmployee(id)
                .map(EmployeeUpdateMapping::toDto)
                .collect(Collectors.toList());
    }
}
