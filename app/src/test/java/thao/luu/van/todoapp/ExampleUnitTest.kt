package thao.luu.van.todoapp

import assertk.assertThat
import assertk.assertions.isLessThan
import org.junit.jupiter.api.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertThat(4).isLessThan(2 + 2)
    }
}