package exercises.collections

import org.scalatest._

class RangesSpec extends FlatSpec with Matchers {

  "Range" should "have size x" in {
    val someNumbers = Range(0, 10)
    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be(10)
    second should be(1)
    last should be(9)
  }

  it should "be specified using until" in {
    val someNumbers = Range(0, 10)
    val otherRange = 0 until 10

    (someNumbers == otherRange) should be(true)
  }

  it should "specify a step for an increment" in {
    val someNumbers = Range(2, 10, 3)
    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be(3)
    second should be(5)
    last should be(8)
  }

  it should "not contains its upper bound" in {
    val someNumbers = Range(0, 34, 2)
    someNumbers.contains(33) should be(false)
    someNumbers.contains(32) should be(true)
    someNumbers.contains(34) should be(false)
  }

  it should "contains its upper bound" in {
    val someNumbers = Range(0, 34).inclusive

    someNumbers.contains(34) should be(true)
  }

  it should "also contains its upper bound" in {
    val someNumbers = Range(0, 34).inclusive
    val otherRange = 0 to 34

    (someNumbers == otherRange) should be(true)
  }
}
