package employee.repository;

import employee.domain.EmployeeUpdateData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by idimaster on 5/18/17.
 */
public interface EmployeeUpdateRepository extends CassandraRepository<EmployeeUpdateData> {
    @Query("Select * from employeeUpdate where employeeId=?0")
    Stream<EmployeeUpdateData> findByEmployee(@Param("employeeId") UUID employeeId);
}
