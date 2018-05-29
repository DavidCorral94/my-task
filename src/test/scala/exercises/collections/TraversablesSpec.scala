package exercises.collections

import org.scalatest._

class TraversablesSpec extends FlatSpec with Matchers {

  "Traversables" should "be the same size" in {
    val set = Set(1, 9, 10, 22)
    val list = List(3, 4, 5, 10)
    val result = set ++ list
    result.size should be(7)

    val result2 = list ++ set
    result2.size should be(8)
  }


}
