# Database and Ebean
The configuration for your database is currently (and unfortunately) stored in two places. This is because Flyway needs to know about your database connection as well and the Flyway Gradle plugin is configured through the `build.gradle` file.

With that in mind, it is highly recommended to use environment variables to configure the database credentials. There are actually two big benefits to this approach.

1. Developers maintain their own credentials in environments where they are running local databases, which is helpful when developers all have different passwords for their local databases.
2. Keeps database passwords out of the code repo since they are configured directly on the server.

By default, `generator-kue` does not use environment variables for the H2 connection. This is for ease of use out of the box. The idea is that a new dev can generate the project, and get it running immediately to play around with the framework. Updating the project to use environment variables is simple. In the examples below, assume environment variables named `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` have been set.

**src/main/resources/application.conf**
```
db.default {

  driver = "org.h2.Driver"
  url = ${DB_URL}
  username = ${DB_USERNAME}
  password = ${DB_PASSWORD}

}
```

**build.gradle**
```
flyway {
    url = "$System.env.DB_URL"
    user = "$System.env.DB_USERNAME"
    password = "$System.env.DB_PASSWORD"
}
```

## Ebean Enhancement
Ebean enhances the model classes at compile time in order to add it's functionality. This is done via an Ebean Gradle plugin, and the package is configured in `build.gradle` via the `ebeanEnhance.packages` value. If you want to use a different package for your Ebean model classes, you'll need to update this value inside of `build.gradle`. If you don't update this value to your new package location, you'll get an error message similar to `Bean class com.widgets.models.db.Widget is not enhanced?` in your console/logs.

```
ebeanEnhance {
    packages = 'com.widgets.models.db.**'
}
```

## Configuring Ebean via ServerConfigStartup
TODO

[Running and Debugging << Previous](running-and-debugging.md) | [Next >> Logging](logging.md)
