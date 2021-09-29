/*
 Copyright (C) 2015 - 2019 Electronic Arts Inc.  All rights reserved.
 This file is part of the Orbit Project <https://www.orbit.cloud>.
 See license in LICENSE.
 */

package orbit.application

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import orbit.application.impl.Greeter
import orbit.application.impl.SettingsLoader
import orbit.client.OrbitClient
import orbit.client.OrbitClientConfig
import orbit.server.OrbitServer
import java.time.Duration


fun main() {
    runBlocking {
        val client = OrbitClient(OrbitClientConfig(namespace = "HELLO"))
        val settingsLoader = SettingsLoader()
        val config = settingsLoader.loadConfig()
        val server = OrbitServer(config)
        delay(Duration.ofSeconds(5))
        server.start().join()
        client.start().join()
        val test = client.actorFactory.createProxy(Greeter::class.java, "testKey")
        val response = test.sayHello("World!")
        println(response)
        client.stop().join()
        server.stop().join()
    }
}