package top.fedoseev.springbootgraphqlexample.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fedoseev.springbootgraphqlexample.model.Employee;
import top.fedoseev.springbootgraphqlexample.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    @GraphQLQuery(name = "employee")
    public Employee getByNumber(String number) {
        return repository.getByNumber(number);
    }

    @GraphQLQuery(name = "employees")
    public Page<Employee> find(Pageable paging) {
        return repository.findAll(paging);
    }
}
