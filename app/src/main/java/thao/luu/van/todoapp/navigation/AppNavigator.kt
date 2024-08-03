package thao.luu.van.todoapp.navigation

import androidx.navigation.NavHostController

interface AppNavigator {
    fun navigateTodoScreen()
}


class AppAppNavigatorImpl(private val navController: NavHostController) : AppNavigator {
    override fun navigateTodoScreen() {
        navController.navigate(AppRoute.TODO)
    }
}
