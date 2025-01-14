/*
 * Copyright 2011-2023 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.javaapi.jdbc;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.gatling.javaapi.core.FeederBuilder;

/** The entrypoint of the Gatling JDBC DSL */
public final class JdbcDsl {

  private JdbcDsl() {}

  /**
   * Boostrap a feeder that read a stock of data from a database
   *
   * @param url the database url
   * @param username the credentials username
   * @param password the credentials password
   * @param sql the SQL query
   * @return a FeederBuilder
   */
  @NonNull
  public static FeederBuilder<Object> jdbcFeeder(
      @NonNull String url,
      @NonNull String username,
      @NonNull String password,
      @NonNull String sql) {
    return new FeederBuilder.Impl<>(
        io.gatling.jdbc.Predef.jdbcFeeder(
            url, username, password, sql, io.gatling.core.Predef.configuration()));
  }
}
