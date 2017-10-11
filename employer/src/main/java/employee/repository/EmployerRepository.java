package employee.repository;

import employee.domain.EmployerData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by idimaster on 5/14/17.
 */

public interface EmployerRepository extends CassandraRepository<EmployerData> {

    @Query("Select * from employer where name=?0")
    List<EmployerData> findByName(@Param("name") String name);

    @Query("Select * from employer")
    Stream<EmployerData> findFirst20(Pageable pageable);
}
