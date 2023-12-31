import org.scalatest.Checkpoints
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CheckPointStudy2 extends AnyFlatSpec with Matchers with Checkpoints {

  "Four basic operations" should "work" in {
    "A test" should "pass with checkpoints" in {
      val value1 = 42
      val value2 = 42

      val checkpoint1 = new Checkpoint {
        assert(value1 == value2, "Checkpoint 1 failed")
      }

      val intermediateValue = value1 + value2

      val checkpoint2 = new Checkpoint {
        assert(intermediateValue == 84, "Checkpoint 2 failed")
      }

      val finalValue = intermediateValue * 2

      val checkpoint3 = new Checkpoint {
        assert(finalValue == 168, "Checkpoint 3 failed")
      }

    }
  }
}