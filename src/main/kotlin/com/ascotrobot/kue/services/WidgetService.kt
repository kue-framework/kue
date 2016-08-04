package com.ascotrobot.kue.services

import com.ascotrobot.kue.models.db.Widget
import com.ascotrobot.kue.models.dto.CreateWidgetRequest

/**
 * @author Michael Vaughan
 */
interface WidgetService {

    fun create(createWidgetRequest: CreateWidgetRequest) : Widget

    fun list() : List<Widget>


}