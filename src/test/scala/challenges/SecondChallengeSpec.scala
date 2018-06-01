package challenges

import org.scalatest._

class SecondChallengeSpec extends FlatSpec with Matchers {

  def combinations(total: Int, addends: Int, secure: Set[Int] = Set.empty): List[List[Int]] =
    (1 to 9).toList combinations addends filter (l => l.sum == total && secure.forall(l contains _)) toList


  "Second challenge" should "be able to find the list of combinations with secure" in {

    val approach1 = combinations(10, 3, Set(2))
    val approach2 = combinations(24, 4, Set(3, 8))
    val approach3 = combinations(11, 4)
    val approach4 = combinations(15, 3, Set(7, 2))

    approach1 shouldBe List(
      List(1, 2, 7),
      List(2, 3, 5))

    approach2 shouldBe List(
      List(3, 4, 8, 9),
      List(3, 6, 7, 8))

    approach3 shouldBe List(List(1, 2, 3, 5))

    approach4 shouldBe List(List(2, 6, 7))

  }

}
