package com.ascotrobot.kue.internal

import com.avaje.ebean.EbeanServer
import com.google.inject.AbstractModule
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import javax.sql.DataSource

/**
 * @author Michael Vaughan
 */
class BootstrapModule : AbstractModule() {

    override fun configure() {
        bind(Config::class.java).toInstance(ConfigFactory.load())
        bind(DataSource::class.java).toProvider(BoneCPDataSourceProvider::class.java).asEagerSingleton()
        bind(EbeanServer::class.java).toProvider(EbeanServerProvider::class.java).asEagerSingleton()
    }

}