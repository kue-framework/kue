package com.ascotrobot.kue.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.ascotrobot.kue.models.dto.CreateWidgetRequest
import com.ascotrobot.kue.models.dto.widgetResponse
import com.ascotrobot.kue.services.WidgetService
import spark.Route
import javax.inject.Inject

/**
 * @author Michael Vaughan
 */
class WidgetController @Inject constructor (val objectMapper: ObjectMapper, val widgetService: WidgetService) {

    val create = json(Route() { req, res ->
        val widgetRequest = objectMapper.readValue(req.body(), CreateWidgetRequest::class.java)
        val widget = widgetService.create(widgetRequest)
        widgetResponse(widget)
    })

    val list = json(Route() {req, res ->
        widgetService.list().map { widgetResponse(it) }
    })

    val secureCreate = securedPolitely(create)

    val secureList = securedPolitely(list)

}