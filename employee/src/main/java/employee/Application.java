package employee;

import employee.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by idimaster on 5/14/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private EmployerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //repository.deleteAll();
      /*  EmployerData data = new EmployerData(UUIDs.timeBased(), "Test1");
        data.address = new AddressData("5890 W St John", "AZ", "85308" );
        data.departments = new HashSet<>();
        data.departments.add(new DepartmentData("Dep1", "d1"));
        data.departments.add(new DepartmentData("Dep2", "d2"));
        data.offices = new HashSet<>();
        data.offices.add(new OfficeData("Office1", "o1"));
        data.offices.add(new OfficeData("Office2", "o2"));
        repository.save(data);
        repository.save(new EmployerData(UUIDs.timeBased(), "Test2"));*/
    }

}
