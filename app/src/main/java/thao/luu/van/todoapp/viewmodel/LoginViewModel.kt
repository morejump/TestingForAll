package thao.luu.van.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import thao.luu.van.todoapp.R
import thao.luu.van.todoapp.extesion.isValidEmail
import thao.luu.van.todoapp.navigation.AppNavigator
import thao.luu.van.todoapp.provider.TextResourceProvider

class LoginViewModel(
    private val appNavigator: AppNavigator,
    private val textProvider: TextResourceProvider
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> get() = _state

    fun handleIntent(intent: LoginIntent) {
        viewModelScope.launch {
            when (intent) {
                is LoginIntent.EmailChanged -> {
                    _state.value = _state.value.copy(
                        email = intent.email,
                        emailError = null
                    )
                }

                is LoginIntent.PasswordChanged -> {
                    _state.value = _state.value.copy(
                        password = intent.password,
                        passwordError = null
                    )
                }

                is LoginIntent.Login -> {
                    validateCredentials()
                }
            }
        }
    }

    private fun validateCredentials() {
        val email = _state.value.email
        val password = _state.value.password

        var valid = true
        var emailError: String? = null
        var passwordError: String? = null

        if (!email.isValidEmail()) {
            emailError = textProvider.getString(R.string.invalid_email_address)
            valid = false
        }

        if (password.isEmpty()) {
            passwordError = textProvider.getString(R.string.password_cannot_be_empty)
            valid = false
        }

        if (valid) {
            _state.value = _state.value.copy(
                emailError = null,
                passwordError = null,
                isLoading = false,
                isSuccess = true,
                errorMessage = null
            )
            appNavigator.navigateTodoScreen()
        } else {
            _state.value = _state.value.copy(
                emailError = emailError,
                passwordError = passwordError,
                isLoading = false,
                isSuccess = false,
                errorMessage = textProvider.getString(R.string.invalid_credentials)
            )
        }
    }
}


data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)

sealed class LoginIntent {
    data class EmailChanged(val email: String) : LoginIntent()
    data class PasswordChanged(val password: String) : LoginIntent()
    data object Login : LoginIntent()
}
