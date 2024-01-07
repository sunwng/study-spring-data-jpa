## JPA vs Hibernate vs Spring Data JPA

JPA: Java Persistence API (interface)
- Specification that defines a set of interfaces and annotations for working w/ RDB

Hibernate: Framework that implements interface of JPA
- EntityManagerFactory (JPA interface) → SessionFactory + impl
- EntityManager (JPA interface) → Session + impl
- EntityTransaction (JPA interface) → Transaction + impl

Other implementations of JPA
- EclipseLink, DataNucleus, …

Spring Data JPA: Framework to make it easy to use JPA and its implementations
- We can change a implementation to use by editing its configuration

Reference: https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac