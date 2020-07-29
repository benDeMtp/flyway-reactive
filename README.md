# flyway-reactive project

Reproducer for https://quarkusio.zulipchat.com/#narrow/stream/187030-users/topic/reactive.20mysql.20and.20testcontainers

The goal is to be able to test reactive query with **testcontainer** as databases and **flyway** for initialization

The problem is the uri used to instantiate the container is not compliant with the reactive sql uri

```mvn test```

should print a list of user, but failed.