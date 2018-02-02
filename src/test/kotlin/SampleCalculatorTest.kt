import io.kotlintest.matchers.shouldThrow
import io.kotlintest.mock.`when`
import io.kotlintest.specs.BehaviorSpec
import org.mockito.Mockito
import kotlin.test.assertEquals

class SampleCalculatorTests : BehaviorSpec() {
    init {
        given("a calculator") {
            val calculator = SampleCalculator()
            val c = Mockito.mock(SampleCalculator::class.java)
            `when`(c.sum(2, 4)).thenReturn(3)


            `when`("addition") {
                val sum = calculator.sum(2,4)
                then("should return the result of adding the first number to the second number") {
                    assertEquals(6, sum)
                }
            }
            `when`("addition with mock") {
                val sum = c.sum(2,4)
                then("should return the mocked result ") {
                    assertEquals(3, sum)
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