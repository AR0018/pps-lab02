object Task3 extends App:

  // a)

  println("Part A")

  val positive: Int => String = _ match
    case x if x >= 0 => "positive"
    case _ => "negative"

  println("Function literal:")
  println(positive(3))
  println(positive(-3))

  def positiveMethod(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  println("Method:")
  println(positiveMethod(3))
  println(positiveMethod(0))
  println(positiveMethod(-1))

  // b)
  println("\n\nPart B")

  // Versione iniziale del neg
  val verboseNeg: (String => Boolean) => String => Boolean = (f: String => Boolean) => (s:String) => s match
    case s if f(s) => false
    case _ => true

  // Versione compatta e più elegante di neg. "f" è la funzione di tipo String => Boolean e "!f(_)" è una lambda
  // che, a partire da una stringa di input, genera un valore booleano che è l'opposto di quello restituito da f
  val neg: (String => Boolean) => String => Boolean = f => !f(_)

  println("Function literal:")
  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = neg(empty) // which type of notEmpty?
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test

  def negMethod(f:String => Boolean): String => Boolean = !f(_)

  println("Method:")
  val notEmptyMethod = negMethod(empty) // which type of notEmpty?
  println(notEmptyMethod("foo")) // true
  println(notEmptyMethod("")) // false
  println(notEmptyMethod("foo") && !notEmptyMethod("")) // true.. a comprehensive test