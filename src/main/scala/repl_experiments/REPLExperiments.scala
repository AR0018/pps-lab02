object REPLExperiments:
  // non-higher-order, i.e., "first order"
  val f = (x: Int, y: Int) => x + y
  // higher-order function: some input/ouput is a function itself
  val h: (Int, Int, (Int, Int) => Int) => Int = (a, b, f) => f(a, b)

  println(h(10, 5, (x, y) => 2 * x + y))
  println(h(10, 5, 2 * _ + _))

  def f2(f: Int => Int, a: Int): Int = f(a)
  println(f2(x => x, 3))
  println(f2(_ + 1, 3))
  println(f2(_, 3)) // Non funziona perché con solo un placeholder e nient'altro, considera tutto lo statement come una lambda
  println(f2(identity, 3)) // Il modo più compatto per esprimere l'identità è x => x o identity

  def curriedSumOfThree(x: Double)(y: Double)(z: Double):Double = x + y + z

  val firstSum = (x: Double) => curriedSumOfThree(x)

  firstSum(3)
  firstSum(3)(4)
  firstSum(3)(4)(2)


