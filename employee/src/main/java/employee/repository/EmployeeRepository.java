package employee.repository;

import employee.domain.EmployeeData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by idimaster on 5/18/17.
 */
public interface EmployeeRepository extends CassandraRepository<EmployeeData> {
    @Query("Select * from employee where employerId=?0")
    Stream<EmployeeData> findByEmployer(@Param("employerId") UUID employerId);
}
