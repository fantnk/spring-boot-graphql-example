package top.fedoseev.springbootgraphqlexample.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fedoseev.springbootgraphqlexample.model.Subdivision;
import top.fedoseev.springbootgraphqlexample.repository.SubdivisionRepository;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Transactional
public class SubdivisionService {

    private final SubdivisionRepository repository;

    @GraphQLQuery(name = "subdivision")
    public Subdivision getByNumber(String code) {
        return repository.getByCode(code);
    }

    @GraphQLQuery(name = "subdivisions")
    public Page<Subdivision> find(Pageable paging) {
        return repository.findAll(paging);
    }
}
