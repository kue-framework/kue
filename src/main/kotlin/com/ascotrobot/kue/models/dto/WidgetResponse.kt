package com.ascotrobot.kue.models.dto

import com.ascotrobot.kue.models.db.Widget
import java.util.*

/**
 * @author Michael Vaughan
 */
data class WidgetResponse(val id: UUID?, val name: String?, val color: String?)

fun widgetResponse(widget: Widget) = WidgetResponse(widget.id, widget.name, widget.color)
