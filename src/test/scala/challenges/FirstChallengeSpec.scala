package challenges

import org.scalatest._

class FirstChallengeSpec extends FlatSpec with Matchers {

  def combinationsA(total: Int, addends: Int): List[List[Int]] = {
    val lists = (1 to 9).toList.toSet[Int].subsets.map(_.toList).toList // ref.: https://stackoverflow.com/a/13109916/5582307
    val combs = lists.filter(p => p.size <= addends && p.size >= addends)
    val solution = combs.filter(p => p.sum == total)
    //println("* Solutions: " + solution)
    solution
  }

  def combinationsB(total: Int, addends: Int): List[List[Int]] = {
    val combs = (1 to 9).toList.combinations(addends)
    val solution = combs.filter(list => list.sum == total).toList
    //println("* Solutions: " + solution)
    solution
  }

  "First challenge" should "give all combinations" in {
    combinationsA(8, 2) should be(List(List(5, 3), List(1, 7), List(6, 2)))
    combinationsA(7, 2) should be(List(List(5, 2), List(1, 6), List(3, 4)))

    combinationsB(8, 2) should be(List(List(1, 7), List(2, 6), List(3, 5)))
    combinationsB(7, 2) should be(List(List(1, 6), List(2, 5), List(3, 4)))
  }

}
