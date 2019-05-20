/*
 * Copyright 2018-2019 scala-steward contributors
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

package org.scalasteward.core.util

import cats.implicits._
import cats.{Foldable, Functor}
import org.scalasteward.core.model.Update

object logger {
  def showUpdates[F[_]: Foldable: Functor](updates: F[Update]): String = {
    val list = string.indentLines(updates.map(_.show))
    updates.size match {
      case 0 => s"Found 0 updates"
      case 1 => s"Found 1 update:\n$list"
      case n => s"Found $n updates:\n$list"
    }
  }
}
