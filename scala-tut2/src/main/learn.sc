

def fact(n: Int) = product(x => x)(1, n)

fact(5)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  def recur(a: Int): Int =
    if a > b then zero
    else combine(f(a) , recur(a+1))
  recur(a)

def sum(f : Int => Int) = mapReduce(f, (x, y) => x + y, 0)

sum(fact)(1,5)

def product(f: Int => Int) = mapReduce(f, (x, y) => x * y, 1)

product(identity)(1,6)

class Rational(x: Int, y: Int):
    def numer = x
    def denom = y


    def add(r: Rational) =
      Rational(numer * r.denom + r.numer * denom, denom * r.denom)
    def neg = Rational(-numer, denom)
    def sub(r: Rational) = add(r.neg)


def removeAt[T](n: Int, xs: List[T]): List[T] = xs match
  case Nil => Nil
  case y :: ys =>
    if n == 0 then ys
    else y :: removeAt(n-2, ys)


val xs = List('a', 'b', 'c', 'd', 'e')
removeAt(2, xs)

def flatten(xs: Any): List[Any] = xs match {
  case Nil => Nil
  case y :: ys => flatten(y) ++ flatten(ys)
  case _ => xs :: Nil


}

val ys = List(List(1, 1), List(3, List(5, 8)))
flatten(ys)

extension [T](xs: List[T])
  def map[U](f: T => U): List[U] = xs match {
    case Nil => xs
    case x :: xs => f(x) :: xs.map(f)
  }
List(1,2,3).map(_ * 2)



// pack
// List((List("a","a","a"), List("b"), List("c","c"), List("a"))

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (more, rest) = xs1.span(y => y == x)
    (x :: more) :: pack(rest)

}
val elems = List("a","a","a","b","c","c","a")
pack(elems)

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs).map(x => (x.head, x.length))

encode(elems)


enum Tree:
  case Inner(left: Tree, right: Tree)
  case Leaf(x: Int)

def trees: Generator[Tree] =  
  for 
    isLeaf <- booleans
    tree <- if isLeaf then leafs else inners
  yield 
    tree

def leafs =
  for x <- integers yield Tree.Leaf(x)

def inners =
  for  x <- trees: y <- trees yield Tree.Inner(x,y)

trees.generate()


