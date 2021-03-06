/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Eclipse Microprofile Tracing implementation for helidon microprofile.
 */
module io.helidon.mp.tracing {
    requires java.logging;
    requires java.annotation;

    requires java.ws.rs;
    requires jersey.common;
    requires opentracing.api;

    requires cdi.api;
    requires javax.inject;

    requires io.helidon.mp.server;
    requires io.helidon.common;
    requires io.helidon.webserver;
    requires transitive io.helidon.tracing;
    requires transitive io.helidon.tracing.jersey;

    exports io.helidon.microprofile.tracing;

    provides io.helidon.microprofile.server.spi.MpService with io.helidon.microprofile.tracing.MpTracingService;
    provides org.glassfish.jersey.internal.spi.AutoDiscoverable with io.helidon.microprofile.tracing.MpTracingAutoDiscoverable;
}
