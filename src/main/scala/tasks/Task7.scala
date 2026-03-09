import scala.annotation.tailrec

object Task7 extends App:

  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case exponent if exponent > 0 => base * power(base, exponent - 1)

  def powerTail(base: Double, exponent: Int): Double =
    @tailrec
    def _power(acc: Double, exponent: Int): Double = exponent match
      case 0 => 1
      case 1 => acc
      case exponent if exponent >= 0 => _power(acc * base, exponent - 1)
    _power(base, exponent)

  println("No tail:")
  println(power(2, 3)) // 8.0
  println(power(5, 2)) // 25.0
  println(power(5, 0)) // 1.0

  println("Tail:")
  println(powerTail(2, 3)) // 8.0
  println(powerTail(5, 2)) // 25.0
  println(powerTail(5, 0)) // 1.0