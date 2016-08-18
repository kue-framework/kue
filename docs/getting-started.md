# Getting Started

1. You can generate a new project using [Yeoman](http://yeoman.io/). Install the kue generator.

    ```
    npm install -g generator-kue
    ```

2. Create a new directory and change into that directory.

    ```
    mkdir widgets-api && cd widgets-api
    ```

3. Generate the project.

    ```
    yo kue
    ```

4. Answer the prompts or leave the defaults. The rest of this guide assumes the defaults were used.

5. Start the app.

    ```
    gradle run --continuous
    ```

6. Create a Widget.

    ```
    curl -X POST -H "Content-Type: application/json" -d '{"name": "Foo", "color": "orange"}' "http://localhost:4567/widgets"
    ```

7. View a list of existing Widgets.

    ```
    curl -X GET "http://localhost:4567/widgets"
    ```

8. Start exploring the code in `src/main/kotlin/com/widgets/Routes.kt`. This is where all of the Spark routes are mapped. Learn more about [Spark routes](http://sparkjava.com/documentation.html#routes).

9. These routes are loaded by a Guice module defined at `src/main/kotlin/com/widgets/Module`. This is also where the `WidgetController` and the `WidgetService` is bound as well. Learn more about [Guice](https://github.com/google/guice/wiki/Motivation).

10. The application knows about the Guice module because the main class located inside of kue-core loads any modules defined in a config file for property `guice.modules`. Look inside of `src/main/resources/application.conf` for this application's config file. Learn more about [Typesafe Config](https://github.com/typesafehub/config).

11. Now let's add a route to GET a specific widget by ID. Start by adding the following function to `com.widgets.services.WidgetService`

    ```
    fun get(id: UUID) : Widget?
    ```

12. After saving, you'll notice in the console where you started the app with `gradle run --continuous` it reloaded after detecting the change.

13. Add the implementation to `com.widgets.services.impl.DefaultWidgetService`

    ```
    override fun get(id: UUID): Widget? = Ebean.find(Widget::class.java).where().idEq(id).findUnique()
    ```

14. Add the controller action to `com.widgets.controllers.WidgetController`:

    ```
    val get = json(Route() { req, res ->
        val uuid = UUID.fromString(req.params("id"))
        val widget = widgetService.get(uuid)
        if (widget != null) {
            widgetResponse(widget)
        } else {
            res.status(404)
        }
    })
    ```

15. Add the route to `com.widgets.Route`

    ```
    get("/widgets/:id", widgetController.get)
    ```

16. You can now view a single Widget instance at `GET localhost:4567/widgets/<uuid-of-widget>`

[Next >> Running and Debugging](docs/running-and-debugging.md)
