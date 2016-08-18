# Running and Debugging

Below are the details for running and debugging a Kue application.

## Running an Application
```
gradle run --continuous
```

## Debugging an Application
To debug a Kue application, use a remote debugger. This is usually fairly easy
to configure from within your IDE of choice. The command below will start the
remote debugger for the Kue application on port 9999.
```
gradle run -Pdebug=9999 --continuous
```

[Getting Started << Previous](docs/getting-started.md) | [Next >> Database and Ebean](docs/database-and-ebean.md)
