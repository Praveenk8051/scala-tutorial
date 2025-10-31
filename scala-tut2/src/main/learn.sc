

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
