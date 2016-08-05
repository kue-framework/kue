package com.widgets.services

import com.widgets.models.db.Widget
import com.widgets.models.dto.CreateWidgetRequest

/**
 * @author Michael Vaughan
 */
interface WidgetService {

    fun create(createWidgetRequest: CreateWidgetRequest) : Widget

    fun list() : List<Widget>


}