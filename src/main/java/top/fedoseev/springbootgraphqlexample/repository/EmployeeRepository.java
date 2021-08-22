package top.fedoseev.springbootgraphqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.fedoseev.springbootgraphqlexample.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getByNumber(String number);

}
