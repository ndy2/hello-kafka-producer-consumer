import org.scalatest.Checkpoints
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CheckPointStudy extends AnyFunSpec with Matchers with Checkpoints {

  def checkpoint(fn: Checkpoint => Unit): Unit = {
    val cp = new Checkpoint
    fn(cp)
    cp.reportAll()
  }

  it("four basic operation") {
    checkpoint { cp =>
      cp { 1 + 1 should equal(2); println("1+1") }
      cp { 2 + 2 should equal(4); println("2+2") }
    }

    checkpoint { cp =>
      cp { 1 + 1 should equal(2); println("1+1") }
      cp { 2 + 2 should equal(4); println("2+2") }
    }
  }
}
