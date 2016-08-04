package com.ascotrobot.kue

import com.google.inject.AbstractModule
import com.ascotrobot.kue.controllers.WidgetController
import com.ascotrobot.kue.services.WidgetService
import com.ascotrobot.kue.services.impl.DefaultWidgetService


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