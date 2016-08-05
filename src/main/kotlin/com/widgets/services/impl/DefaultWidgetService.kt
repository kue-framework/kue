package com.widgets.services.impl

import com.widgets.models.db.Widget
import com.widgets.models.dto.CreateWidgetRequest
import com.widgets.services.WidgetService
import com.avaje.ebean.Ebean

/**
 * @author Michael Vaughan
 */
class DefaultWidgetService : WidgetService {

    override fun create(createWidgetRequest: CreateWidgetRequest): Widget {
        val widget = Widget(createWidgetRequest)
        widget.save()
        return widget
    }

    override fun list(): List<Widget> = Ebean.find(Widget::class.java).findList()

}