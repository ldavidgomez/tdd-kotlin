import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class SampleTests : BehaviorSpec() {
    init {
        given("String") {
            `when`("String.length") {
                then("return the length of the string") {
                    "sammy".length shouldBe 5
                    "".length shouldBe 0
                }
            }
        }
    }
}