#Logging

Logging is a powerful tool for monitoring, debugging, and error tracking in your application. Kue provides an API for logging which at the core is based on [SLF4J](http://www.slf4j.org/) with [Logback](http://logback.qos.ch/) as the default logging engine.

## Using the Log
Kue provides the `com.kue.core.Log` object which can be used to log at the following levels: 

* ERROR
* WARN
* INFO
* DEBUG
* TRACE

```kotlin
import com.kue.core.Log

class MyClass {

  fun doSomething() {
    Log.info("Doing something!")
  }

}
```

`Log` serves as the default logger using the name `application`. You can use it for your application or you could even create your own `Logger` using SLF4J's `LoggerFactory.getLogger()` function.

## Configuration
You can configure Logback in `src/main/resources/logback.xml`. By default the `application` logger is set to `DEBUG` and the `root` logger is set to `WARN`.

```xml
<logger name="application" level="DEBUG" />

<root level="WARN">
    <appender-ref ref="ASYNCFILE" />
    <appender-ref ref="ASYNCSTDOUT" />
</root>
```

You can configure specific logger levels or just match the start of there names in `logback.xml`.

```xml
<!-- Match ALL ebean loggers with com.avaje -->
<logger name="org.avaje" level="DEBUG" />

<!-- Or only turn the SQL logger to debug -->
<logger name="org.avaje.ebean.SQL" level="DEBUG" />
```

For more information about configuring Logback, please refer to their [extensive documentation](http://logback.qos.ch/manual/index.html).

