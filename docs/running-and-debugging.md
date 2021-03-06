# Running and Debugging

Below are the details for running and debugging a Kue application.

## Running an Application
By default the application starts on port 4567.
```
gradle run --continuous
```
Use -Pport=<port> to change the port the application runs on.
```
gradle run -Pport=9000 --continuous
```

## Debugging an Application
To debug a Kue application, use a remote debugger. This is usually fairly easy
to configure from within your IDE of choice. The command below will start the
remote debugger for the Kue application on port 9999.
```
gradle run -Pdebug=9999 --continuous
```

## JVM Arguments and Options
You can specify JVM options via `-PjvmOpts=<options>`.
```
gradle run -PjvmOpts="-Xmx1024m -Dfoo=bar" --continuous
```

[Getting Started << Previous](getting-started.md) | [Next >> Database and Ebean](database-and-ebean.md)
