package com.widgets.models.db

import com.avaje.ebean.config.ServerConfig
import com.avaje.ebean.config.ServerConfig.DbUuid.VARCHAR
import com.avaje.ebean.event.ServerConfigStartup

/**
 * @author Michael Vaughan
 */
class WidgetServerConfigStartup : ServerConfigStartup {

    override fun onStart(serverConfig: ServerConfig?) {
        serverConfig?.dbUuid = VARCHAR
    }
}