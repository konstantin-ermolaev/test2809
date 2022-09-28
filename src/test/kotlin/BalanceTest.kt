
import assertk.assertThat
import assertk.assertions.hasMessage
import assertk.assertions.isEqualTo
import assertk.assertions.isFailure
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BalanceTest {
    val balanceService = BalanceService()

    @Test
    fun plusBalanceTest() {
        balanceService.plusBalance(200)
        assertThat(balanceService.getBalance()).isEqualTo(200)
        assertThat{
            throw Exception("error")
        }.isFailure().hasMessage("error")
        assertEquals(200, balanceService.getBalance())
    }

    @Test
    fun minusBalanceTest() {
        balanceService.minusBalance(200)
        assertEquals(-200, balanceService.getBalance())
    }

    @RepeatedTest(4)
    fun getBalance() {
        assertEquals(0, balanceService.getBalance())
    }

    @ParameterizedTest
    @ValueSource(longs = [200,300,400,500])
    @MethodSource("balanceCount")

    fun parameterizedTest(count: Long) {
        balanceService.plusBalance(count)
        assertEquals(count,balanceService.getBalance())
    }

    companion object {
        @JvmStatic
        fun balanceCount() : Stream<Long> {
            return Stream.of(200,300,400)
        }

        @BeforeAll
        @JvmStatic
        fun BeforeAll () {

            println("Before all works")
        }
    }

}
