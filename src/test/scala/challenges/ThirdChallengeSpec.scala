package challenges

import org.scalatest._

class ThirdChallengeSpec extends FlatSpec with Matchers {

  case class Spaces(total: Int, addends: Int, secure: Set[Int] = Set.empty) {
    def comb: List[List[Int]] = (1 to 9).toList combinations addends filter (l => l.sum == total && secure.forall(l contains _)) toList
  }

  case class Hand(a: Spaces, b: Spaces) {
    def solve: Int = {
      println("A Spaces: ", a.comb)
      println("B Spaces: ", b.comb)
      val flattenA = a.comb.flatten
      val flattenB = b.comb.flatten
      println("A Flatten: ", flattenA)
      println("B Flatten: ", flattenB)
      val setA = flattenA.toSet diff a.secure
      val setB = flattenB.toSet diff b.secure
      println("A Set: ", setA)
      println("B Set: ", setB)
      val intersectAndB = setA.intersect(setB)
      println("A intersect B: " + intersectAndB)

      val sol = intersectAndB.toList match {
        case Nil => 0
        case head :: Nil => head
        case _ => -1
      }

      sol
    }

    def solveInline: Int = {
      a.comb.flatten.toSet.diff(a.secure).intersect(b.comb.flatten.toSet.diff(b.secure)).toList match {
        case Nil => 0
        case head :: Nil => head
        case _ => -1
      }
    }
  }

  "Hand.solve" should "be able to find the solution when 2 compatible hands without secures are passed" in {

    val space1 = Spaces(13, 4, Set(1))
    val space2 = Spaces(24, 3)

    Hand(space1, space2).solveInline shouldBe 7
  }


  it should "be able to find the solution when 2 compatible hands with secures are passed" in {

    val space1 = Spaces(10, 2, Set(3))
    val space2 = Spaces(24, 3, Set(9))

    Hand(space1, space2).solveInline shouldBe 7
  }

  it should "be able to find the solution when 2 compatible hands with/without secures are passed" in {

    val space1 = Spaces(12, 4, Set(3))
    val space2 = Spaces(22, 3)
    val hand = Hand(space1, space2)

    hand.solveInline shouldBe 6
  }


  it should "return 0 when both spaces has no any possible intersection" in {

    val space1 = Spaces(8, 3)
    val space2 = Spaces(23, 3)
    val hand = Hand(space1, space2)

    hand.solveInline shouldBe 0
  }

  it should "return -1 when exist several possible solutions" in {

    val space1 = Spaces(12, 2)
    val space2 = Spaces(23, 4)
    val hand = Hand(space1, space2)

    hand.solveInline shouldBe -1
  }

  it should "be able to find the unique solution when secures are restrictive" in {
    val space1 = Spaces(19, 4, Set(5, 6))
    val space2 = Spaces(16, 4, Set(7))

    Hand(space1, space2).solveInline shouldBe 1
  }

}
