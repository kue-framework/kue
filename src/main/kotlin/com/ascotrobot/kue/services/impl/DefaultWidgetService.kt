package com.ascotrobot.kue.services.impl

import com.ascotrobot.kue.models.db.Widget
import com.ascotrobot.kue.models.dto.CreateWidgetRequest
import com.ascotrobot.kue.services.WidgetService
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