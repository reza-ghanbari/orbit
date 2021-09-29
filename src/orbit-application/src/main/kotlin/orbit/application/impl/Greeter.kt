/*
 Copyright (C) 2015 - 2021 Electronic Arts Inc.  All rights reserved.
 This file is part of the Orbit Project <https://www.orbit.cloud>.
 See license in LICENSE.
 */

package orbit.application.impl

import orbit.client.actor.ActorWithStringKey

interface Greeter: ActorWithStringKey {
    suspend fun sayHello(name: String): String
}