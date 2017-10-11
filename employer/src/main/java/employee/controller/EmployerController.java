package employee.controller;

import com.datastax.driver.core.utils.UUIDs;
import employee.controller.dto.Employer;
import employee.controller.dto.EmployerInfo;
import employee.controller.mapping.EmployerMapping;
import employee.domain.EmployerData;
import employee.notification.EmployerNotification;
import employee.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by idimaster on 5/14/17.
 */
@RestController
public class EmployerController {
    private static final String NO_EMPLOYER = "No Employer found for ID ";

    @Autowired
    private EmployerRepository repository;

    @Autowired
    private EmployerNotification notification;

    @GetMapping("/employers")
    public List<EmployerInfo> employers(Pageable pageable) {
        return repository.findFirst20(pageable)
                .limit(20)
                .map(EmployerMapping::toInfo)
                .collect(Collectors.toList());
    }

    @GetMapping("/employers/{id}")
    public ResponseEntity employers(@PathVariable("id") UUID id) {
        MapId mid = new BasicMapId().with("id", id);
        return Optional.ofNullable(repository.findOne(mid))
                .map(EmployerMapping::toDto)
                .map(emp -> new ResponseEntity(emp, HttpStatus.OK))
                .orElse(new ResponseEntity(NO_EMPLOYER + id, HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/employers")
    public ResponseEntity createEmployer(@RequestBody Employer employer) {
        employer.setId(UUIDs.timeBased());
        EmployerData data = repository.insert(EmployerMapping.fromDto(employer));
        notification.add(EmployerMapping.toDto(data));
        return new ResponseEntity(EmployerMapping.toDto(data), HttpStatus.OK);
    }

    @DeleteMapping("/employers/{id}")
    public ResponseEntity deleteEmployer(@PathVariable UUID id) {
        MapId mid = new BasicMapId().with("id", id);
        if (!repository.exists(mid)) {
            new ResponseEntity(NO_EMPLOYER + id, HttpStatus.NOT_FOUND);
        }
        repository.delete(mid);
        notification.delete(new Employer(id));
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping("/employers/{id}")
    public ResponseEntity updateEmployer(@PathVariable UUID id, @RequestBody Employer employer) {
        MapId mid = new BasicMapId().with("id", id);
        if (!repository.exists(mid)) {
            new ResponseEntity(NO_EMPLOYER + id, HttpStatus.NOT_FOUND);
        }
        employer.setId(id);
        EmployerData data = repository.save(EmployerMapping.fromDto(employer));
        notification.update(EmployerMapping.toDto(data));
        return new ResponseEntity(EmployerMapping.toDto(data), HttpStatus.OK);
    }
}
