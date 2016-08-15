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

`Log` serves as the default logger using the name "application." You can use it for your application or you could even create your own `Logger` using SLF4J's `LoggerFactory.getLogger()` function.
