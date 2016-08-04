package com.ascotrobot.kue.internal

import com.jolbox.bonecp.BoneCPDataSource
import com.typesafe.config.Config
import javax.inject.Inject
import javax.inject.Provider
import javax.sql.DataSource

/**
 * @author Michael Vaughan
 */
class BoneCPDataSourceProvider @Inject constructor(val config: Config) : Provider<DataSource> {

    override fun get(): DataSource? {

        val driver = config.getString("db.default.driver")
        val url = config.getString("db.default.url")
        val username = config.getString("db.default.username")
        val password = config.getString("db.default.password")

        Class.forName(driver);
        return BoneCPDataSource().apply {
            this.jdbcUrl = url
            this.username = username
            this.password = password
        }

    }
}