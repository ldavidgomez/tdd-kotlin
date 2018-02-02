import io.kotlintest.specs.BehaviorSpec
import kotlin.test.assertEquals

class SampleCalculatorTests : BehaviorSpec() {
    init {
        given("a calculator") {
            val calculator = SampleCalculator()
            `when`("addition") {
                val sum = calculator.sum(2,4)
                then("should return the result of adding the first number to the second number") {
                    assertEquals(6, sum)
                }
            }
            `when`("subtraction") {
                val subtract = calculator.subtract(4, 2)
                then("should return the result of subtracting the second number from the first number") {
                    assertEquals(2, subtract)
                }
            }
        }
    }
}