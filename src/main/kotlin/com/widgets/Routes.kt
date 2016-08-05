package com.widgets

import com.widgets.controllers.WidgetController
import spark.Spark.*
import javax.inject.Inject

/**
 * @author Michael Vaughan
 */

class Routes @Inject constructor(widgetController: WidgetController) {

    init {
        post("/widgets", widgetController.create)
        post("/secure/widgets", widgetController.secureCreate)
        get("/widgets", widgetController.list)
        get("/secure/widgets", widgetController.secureList)
    }

}
