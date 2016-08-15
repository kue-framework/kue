# Kue
An opinionated, Kotlin friendly web framework, that brings over some of my favorite things from [Play Framework](https://www.playframework.com/) without a dependency on Scala.

## Goals
* Project should auto reload or hotswap when source files change.
* Ability to easily compose HTTP actions.
* Easy to use, yet robust configuration mechanism.
* Dependency injection friendly.
* Robust database evolutions mechanism.
* Kotlin and Java friendly.
* Opinionated out of the box, but allows you to easily swap out the parts if desired.
* No SBT.
* No Scala.
* Favor Guice over Spring.

## Components
* [Kotlin](http://kotlinlang.org/)
* [Gradle](https://gradle.org/)
* [Typesafe Config](https://github.com/typesafehub/config)
* [Google Guice](https://github.com/google/guice)
* [Spark Java](http://sparkjava.com/)
* [EBean ORM](http://ebean-orm.github.io/)
* [BoneCP](http://www.jolbox.com/)
* [Flyway DB](https://flywaydb.org)
* [Jackson](https://github.com/FasterXML/jackson)

## Documentation
1. [Getting Started](docs/getting-started.md)
2. [Database and Ebean](docs/database-and-ebean.md)
3. [Logging](docs/logging.md)
