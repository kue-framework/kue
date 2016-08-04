package com.ascotrobot.kue

import com.ascotrobot.kue.controllers.WidgetController
import com.fasterxml.jackson.databind.ObjectMapper
import spark.ResponseTransformer
import spark.Spark.*
import javax.inject.Inject

/**
 * @author Michael Vaughan
 */

class JsonTransformer @Inject constructor(val objectMapper: ObjectMapper) : ResponseTransformer {

    override fun render(model: Any?): String = objectMapper.writeValueAsString(model)

}

class Routes @Inject constructor(objectMapper: ObjectMapper, jsonTransformer: JsonTransformer, widgetController: WidgetController) {

    init {
        post("/widgets", widgetController.create, jsonTransformer)
        post("/secure/widgets", widgetController.secureCreate)
        get("/widgets", widgetController.list)
        get("/secure/widgets", widgetController.secureList)
    }

}
