package exercises.collections

import org.scalatest._

class SequencesAndArraysSpec extends FlatSpec with Matchers {

  "Sequence or Array" should "be created from list" in {
    val l = List(1, 2, 3)
    val a = l.toArray
    a should equal(Array(1, 2, 3))
  }

  it should "be converted to list" in {
    val a = Array(1, 2, 3)
    val s = a.toSeq
    val l = s.toList
    l should equal(List(1, 2, 3))
  }

  it should "be created from for loop" in {
    val s = for (v ← 1 to 4) yield v
    s.toList should be(List(1, 2, 3, 4))
  }

  it should "be created from for loop with filter" in {
    val s = for (v ← 1 to 10 if v % 3 == 0) yield v
    s.toList should be(List(3, 6, 9))
  }

  it should "be filtered by predicated" in {
    val s = Seq("hello", "to", "you")
    val filtered = s.filter(_.length > 2)
    filtered should be(Seq("hello", "you"))
  }

  it should "be filtered also if its an array" in {
    val a = Array("hello", "to", "you", "again")
    val filtered = a.filter(_.length > 3)
    filtered should be(Array("hello", "again"))
  }

  it should "be mapped throught a function" in {
    val s = Seq("hello", "world")
    val r = s map {
      _.reverse
    }

    r should be(List("olleh", "dlrow"))
  }
}
