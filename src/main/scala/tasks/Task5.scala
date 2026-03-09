object Task5 extends App:
  def compose(f: Int => Int, g: Int => Int): Int => Int = i => f(g(i))

  // NOTA: La forma più compatta del corpo di compose è quella riportata sopra.
  // NON si può fare semplicemente:
  // def compose(f: Int => Int, g: Int => Int): Int => Int = f(g(_))
  // Questo perché, in Scala, l'underscore _ si basa sempre sullo SCOPE PIU' INTERNO.
  // Di conseguenza, l'espressione f(g(_)) NON viene valutata come x => f(g(x)) come vorremmo,
  // ma come: f(x => g(x))
  // in quanto lo scope dell'underscore è quello delle parentesi della f, invece che quello esterno.
  // Ciò, naturalmente, restituisce errore perché ad f stiamo passando una lambda, e non più un intero.

  // Se, invece, l'obiettivo della nostra funzione fosse semplicemente di chiamare f, allora si potrebbe tranquillamente
  // scrivere: f(_), in quanto lo scope dell'underscore sarebbe quello esterno, e quindi l'espressione verrebbe
  // valutata come x => f(x).

  println(compose(_ - 1, _ * 2)(5)) // 9
