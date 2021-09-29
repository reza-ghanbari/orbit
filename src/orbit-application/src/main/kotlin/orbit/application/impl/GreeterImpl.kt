/*
 Copyright (C) 2015 - 2021 Electronic Arts Inc.  All rights reserved.
 This file is part of the Orbit Project <https://www.orbit.cloud>.
 See license in LICENSE.
 */

package orbit.application.impl

import orbit.client.actor.AbstractActor

class GreeterImpl: AbstractActor(), Greeter {
    override suspend fun sayHello(name: String): String {
        println("Hello $name!")
        return ("You said: 'Hello $name', I say: 'Hello from ${context.reference.key} at node ${context.client.nodeId?.key}!'")
    }
}