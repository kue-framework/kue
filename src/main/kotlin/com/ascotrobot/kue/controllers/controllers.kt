package com.ascotrobot.kue.controllers

import com.ascotrobot.kue.json.JSON
import spark.Route

/**
 * @author Michael Vaughan
 */



fun securedPolitely(next: Route) = Route() { req, res ->
    if ("please".equals(req?.headers("Authorization") ?: "")) {
        next.handle(req, res)
    } else {
        res?.status(401)
        ""
    }
}


fun json(next: Route) = Route() { req, res ->
    res.type("application/json")
    JSON.writeValueAsString(next.handle(req, res))
}

