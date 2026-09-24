package tasks

import scala.annotation.tailrec

object Task7New extends App {
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  def powerTailrec(base: Double, exponent: Int): Double =
    @tailrec
    def _power(acc: Double, base: Double, exponent: Int): Double = exponent match
      // If we remove "base" from signature, the correct match case is the one shown in Task7
      case 0 => acc
      case _ => _power(acc * base, base, exponent - 1)
    _power(1, base, exponent)

  println((power(2, 3), power(5, 2))) // (8.0, 25.0)
  println((powerTailrec(2, 3), powerTailrec(5, 2))) // (8.0, 25.0)
}
