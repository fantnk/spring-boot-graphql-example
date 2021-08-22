package top.fedoseev.springbootgraphqlexample.model;

import io.leangen.graphql.annotations.GraphQLIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "subdivision", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Subdivision {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    @GraphQLIgnore
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Subdivision parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<Subdivision> sub;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subdivision")
    private Set<Employee> employees;

}
