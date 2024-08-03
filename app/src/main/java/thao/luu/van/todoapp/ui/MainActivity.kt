package thao.luu.van.todoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf
import thao.luu.van.todoapp.navigation.AppNavigator
import thao.luu.van.todoapp.navigation.AppRoute
import thao.luu.van.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val appNavigator: AppNavigator = get { parametersOf(navController) }

    NavHost(navController, startDestination = AppRoute.LOGIN) {
        composable(AppRoute.LOGIN) {
            LoginScreen()
        }
        composable(AppRoute.TODO) {
            TodoListPage()
        }
    }
}

