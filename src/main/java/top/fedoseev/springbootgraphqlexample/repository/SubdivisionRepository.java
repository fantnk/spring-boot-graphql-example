package top.fedoseev.springbootgraphqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.fedoseev.springbootgraphqlexample.model.Subdivision;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

    Subdivision getByCode(String code);
}
