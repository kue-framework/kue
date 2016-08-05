package com.widgets

import com.google.inject.AbstractModule
import com.widgets.controllers.WidgetController
import com.widgets.services.WidgetService
import com.widgets.services.impl.DefaultWidgetService


/**
 * @author Michael Vaughan
 */
class Module : AbstractModule() {

    override fun configure() {
        bind(Routes::class.java).asEagerSingleton()
        bind(WidgetController::class.java)
        bind(WidgetService::class.java).to(DefaultWidgetService::class.java)
    }
}