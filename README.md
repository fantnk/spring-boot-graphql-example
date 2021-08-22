# Spring Boot GraphQL Example

Sample project based on following technologies:
- Spring Boot
- Spring Data JPA
- GraphQL Java
- GraphQL SPQR
- H2
- Gradle

## Run

```shell
./gradlew :bootRun
```

After start service will listen on port 8080. Now you can open http://localhost:8080/gui and try your first GraphQL
query:

```
{
  employees(paging: { pageNumber: 0, pageSize: 5 }) {
    edges {
      node {
        number
        firstName
        lastName
        subdivision {
          code
        }
      }
    }
    pageInfo {
      hasNextPage
    }
  }
}
```

## Known issues

### N+1 problem

There is n+1 problem. To solve it you need implement DataLoaders and write some logic.
