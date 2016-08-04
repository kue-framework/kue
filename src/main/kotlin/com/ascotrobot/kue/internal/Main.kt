package com.ascotrobot.kue.internal

import com.google.inject.Guice
import com.google.inject.Module
import com.typesafe.config.Config


/**
 * @author Michael Vaughan
 */
object Main {

    @JvmStatic
    fun main(args: Array<String>) : Unit {

        // The bootstrap injector allows us to have the Config available for injection as well as using a config value
        // for loading new modules.
        val bootstrap = Guice.createInjector(BootstrapModule())
        val config = bootstrap.getInstance(Config::class.java)

        // Load application.conf defined modules
        val modules = config.getStringList("guice.modules").map {Class.forName(it)}.map {it.newInstance() as Module }
        val injector = bootstrap.createChildInjector(modules)

    }


}