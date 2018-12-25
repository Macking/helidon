/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
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

package io.helidon.config.tests.bundle;

import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.config.ConfigValues;
import io.helidon.config.hocon.HoconConfigParserBuilder;
import io.helidon.config.spi.ConfigParser;
import io.helidon.config.yaml.YamlConfigParserBuilder;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test that all dependencies are included and basic use-case is running.
 */
public class SmokeTest {

    @Test
    public void testPropertiesParser() {
        Config config = Config.builder()
                .sources(ConfigSources.create("key=value", "text/x-java-properties"))
                .build();
        assertThat(config.get("key").asString(), is(ConfigValues.simpleValue("value")));
    }

    @Test
    public void testRequiredModulesIncluded() {
        ConfigParser hoconConfigParser = HoconConfigParserBuilder.buildDefault();
        ConfigParser yamlConfigParser = YamlConfigParserBuilder.buildDefault();
    }
}
