object Task4 extends App:

  val nonCurriedFun: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  val curriedFun: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  def nonCurriedMethod(x:Int, y:Int, z:Int): Boolean = x <= y && y == z
  def curriedMethod(x:Int)(y:Int)(z:Int): Boolean = x <= y && y == z

  // NOTA: La versione curried e quella non curried di uno stesso metodo NON sono sostituibili come parametri
  // di input di una funzione higher-order. Questo vuol dire che non è possibile creare una funzione higher-order che
  // accetta indifferentemente un metodo curried e uno non-curried, in quanto sia la signature, sia la modalità di
  // invocazione sono diverse

  println("Non-curried function:")
  println(nonCurriedFun(3, 5, 5))
  println(nonCurriedFun(4, 1, 3))
  println(nonCurriedFun(4, 5, 6))

  println("Curried function:")
  println(curriedFun(3)(5)(5))
  println(curriedFun(4)(1)(3))
  println(curriedFun(4)(5)(6))

  println("Non-curried method:")
  println(nonCurriedMethod(3, 5, 5))
  println(nonCurriedMethod(4, 1, 3))
  println(nonCurriedMethod(4, 5, 6))

  println("Curried method:")
  println(curriedMethod(3)(5)(5))
  println(curriedMethod(4)(1)(3))
  println(curriedMethod(4)(5)(6))
