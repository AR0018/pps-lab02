package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  val empty = OptionalInt.Empty()
  val nonEmpty = OptionalInt.Just(0)

  @Test def emptyOptionalShouldBeEmpty(): Unit =
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/

  @Test def mapShouldTransformNonEmptyOptional(): Unit =
    assertEquals(OptionalInt.Just(1), OptionalInt.mapInt(nonEmpty)(_ + 1))

  @Test def mapShouldNotTransformEmptyOptional(): Unit =
    assertEquals(empty, OptionalInt.mapInt(empty)(_ + 1))

  @Test def filterWithNonEmptyOptional(): Unit =
    assertEquals(nonEmpty, OptionalInt.filter(nonEmpty)(_ >= 0))
    assertEquals(empty, OptionalInt.filter(nonEmpty)(_ < 0))

  @Test def filterWithEmptyOptionalShouldReturnEmpty(): Unit =
    assertEquals(empty, OptionalInt.filter(empty)(_ >= 0))
