package expr

import org.junit.*
import org.junit.Assert.*
import Expressions.*

class ExpressionsTest:
  // ((4 * 10) + (5 + 3)) = 48
  val expression = Expr.Add(
    Expr.Multiply(Expr.Literal(4), Expr.Literal(10)),
    Expr.Add(Expr.Literal(5), Expr.Literal(3))
  )

  @Test def evaluateExpr(): Unit =
    assertEquals(48, evaluate(expression))

  @Test def showExpr(): Unit =
    assertEquals("((4 * 10) + (5 + 3))", show(expression))
