package expr

import expr.Expressions.Expr.{Add, Literal}

object Expressions extends App:
  enum Expr:
    case Literal(value: Int)
    case Add(e1: Expr, e2: Expr)
    case Multiply(e1: Expr, e2: Expr)

  def evaluate(expr: Expr): Int = {
    def evalOperator(e1: Expr, e2: Expr, operator: (Int, Int) => Int): Int =
      operator(evaluate(e1), evaluate(e2))
    expr match
    case Expr.Literal(n) => n
    case Expr.Add(e1, e2) => evalOperator(e1, e2, _ + _)
    case Expr.Multiply(e1, e2) => evalOperator(e1, e2, _ * _)
  }

  def show(expr: Expr): String =
    def showOperator(e1: Expr, e2: Expr, operator: String): String =
      s"(${show(e1)} $operator ${show(e2)})"
    expr match
    case Expr.Literal(n) => s"$n"
    case Expr.Add(e1, e2) => showOperator(e1, e2, "+")
    case Expr.Multiply(e1, e2) => showOperator(e1, e2, "*")
