/*
 * Copyright 2015-2020 the original author or authors.
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

package io.rsocket.plugins;

import io.rsocket.DuplexConnection;
import java.util.function.BiFunction;

/**
 * Contract to decorate a {@link DuplexConnection} and intercept the sending and receiving of
 * RSocket frames at the transport level.
 */
public @FunctionalInterface interface DuplexConnectionInterceptor
    extends BiFunction<DuplexConnectionInterceptor.Type, DuplexConnection, DuplexConnection> {

  enum Type {
    /**
     * @deprecated as of 1.1 this type is no longer available for interception and will be removed
     *     in 1.2. As an alternative, intercept via {@link Type#SOURCE} and look for frames of type
     *     {@code SETUP}, {@code RESUME}, or {@code RESUME_OK}.
     */
    @Deprecated
    SETUP,
    CLIENT,
    SERVER,
    SOURCE
  }
}
