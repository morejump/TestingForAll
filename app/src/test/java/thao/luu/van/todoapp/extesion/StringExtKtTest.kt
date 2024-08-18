package thao.luu.van.todoapp.extesion

import assertk.assertThat
import assertk.assertions.isFalse
import org.junit.jupiter.api.Test

class StringExtKtTest {

    @Test
    fun `Given invalid email When validate email Then return false`() {
        // Given/Arrange
        val invalidEmail = "%thao@gmail.com"

        // When/Action
        val actual = invalidEmail.isValidEmail()

        // Then/Assert
        assertThat(actual).isFalse()
    }

    @Test
    fun `Should return false When invalid email`() {
        // Given/Arrange
        val invalidEmail = "%thao@gmail.com"

        // When/Action
        val actual = invalidEmail.isValidEmail()

        // Then/Assert
        assertThat(actual).isFalse()
    }
}