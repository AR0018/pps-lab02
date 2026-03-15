import scala.annotation.tailrec

object Task8 extends App:
  val base = 10

  def reverseNumber(n: Int): Int =
    @tailrec
    def reverse(remainingDigits: Int, currentReversed: Int): Int = remainingDigits match
      case 0 => currentReversed
      case _ => reverse(remainingDigits / 10, currentReversed * base + remainingDigits % base)
    reverse(n, 0)

  println(reverseNumber(12345)) //54321
  println(reverseNumber(1)) // 1
