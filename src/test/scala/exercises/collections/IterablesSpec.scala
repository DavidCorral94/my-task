package exercises.collections

import org.scalatest._

class IterablesSpec extends FlatSpec with Matchers {

  "Iterables" should "have next" in {
    val list = List(3, 5, 9, 11, 15, 19, 21)
    val it = list.iterator
    if (it.hasNext) {
      it.next should be(3)
    }
  }

  it should "be grouped" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it = list grouped 3
    it.next() should be(List(3, 5, 9))
    it.next() should be(List(11, 15, 19))
    it.next() should be(List(21, 24, 32))
  }

  it should "be sliding" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it = list sliding 3
    it.next() should be(List(3, 5, 9))
    it.next() should be(List(5, 9, 11))
    it.next() should be(List(9, 11, 15))
  }

  it should "sliding with step" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it = list sliding(3, 3)
    it.next() should be(List(3, 5, 9))
    it.next() should be(List(11, 15, 19))
    it.next() should be(List(21, 24, 32))
  }

  it should "take right elements" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    (list takeRight 3) should be(List(21, 24, 32))
  }

  it should "drop right elements" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    (list dropRight 3) should be(List(3, 5, 9, 11, 15, 19))
  }

  it should "zip two iterables" in {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann", "Stella")
    (xs zip ys) should be(List((3, "Bob"), (5, "Ann"), (9, "Stella")))
  }

  it should "zip the elements that can be zipped" in {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")
    (xs zip ys) should be(List((3, "Bob"), (5, "Ann")))
  }

  it should "zip with default" in {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")
    (xs zipAll(ys, -1, "?")) should be(List((3, "Bob"), (5, "Ann"), (9, "?")))

    val xt = List(3, 5)
    val yt = List("Bob", "Ann", "Stella")
    (xt zipAll(yt, -1, "?")) should be(List((3, "Bob"), (5, "Ann"), (-1, "Stella")
    ))
  }

  it should "zip with index" in {
    val xs = List("Manny", "Moe", "Jack")
    xs.zipWithIndex should be(List(("Manny", 0), ("Moe", 1), ("Jack", 2)))
  }

  it should "be true if same elements are in same order" in {
    val xs = List("Manny", "Moe", "Jack")
    val ys = List("Manny", "Moe", "Jack")
    (xs sameElements ys) should be(true)

    val xt = List("Manny", "Moe", "Jack")
    val yt = List("Manny", "Jack", "Moe")
    (xt sameElements yt) should be(false)

    val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
    val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
    (xs1 sameElements ys1) should be(false)

    val xt1 = Set(1, 2, 3)
    val yt1 = Set(3, 2, 1)
    (xt1 sameElements yt1) should be(false)
  }
}
