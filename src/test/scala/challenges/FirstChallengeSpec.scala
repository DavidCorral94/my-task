package challenges

import org.scalatest._

class FirstChallengeSpec extends FlatSpec with Matchers {

  def combinationsA(total: Int, addends: Int): List[List[Int]] = {
    val lists = (1 to 9).toList.toSet[Int].subsets.map(_.toList).toList // ref.: https://stackoverflow.com/a/13109916/5582307
    val combs = lists.filter(p => p.size <= addends && p.size >= addends)
    val solution = combs.filter(p => p.sum == total)
    print("*Solutions: " + solution)
    solution
  }

  def combinationsB(total: Int, addends: Int): List[List[Int]] = {
    val combs = (1 to 9).toList.combinations(addends)
    val solution = combs.filter(list => list.sum == total).toList
    println("* Solutions: " + solution)
    solution
  }

  def combinationsC(total: Int, addends: Int, secure: Set[Int] = Set.empty): List[List[Int]] =
    (1 to 9).toList combinations addends filter (l => l.sum == total && secure.forall(l contains _)) toList


  "First challenge" should "be able to find the list of combinations" in {

    val approach1 = combinationsC(10, 3, Set(2))
    val approach2 = combinationsC(24, 4, Set(3, 8))
    val approach3 = combinationsC(11, 4)
    val approach4 = combinationsC(15, 3, Set(7, 2))

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
