package thao.luu.van.todoapp.di

import androidx.navigation.NavHostController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import thao.luu.van.todoapp.db.ToDoDatabase
import thao.luu.van.todoapp.navigation.AppAppNavigatorImpl
import thao.luu.van.todoapp.navigation.AppNavigator
import thao.luu.van.todoapp.provider.TextResourceProvider
import thao.luu.van.todoapp.provider.TextResourceProviderImpl
import thao.luu.van.todoapp.repository.ToDoRepository
import thao.luu.van.todoapp.repository.ToDoRepositoryImpl
import thao.luu.van.todoapp.viewmodel.LoginViewModel
import thao.luu.van.todoapp.viewmodel.ToDoViewModel

val appModule = module {
    single { ToDoDatabase.getDatabase(get()) }
    single { get<ToDoDatabase>().getTodoDao() }
    single<ToDoRepository> { ToDoRepositoryImpl(get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { ToDoViewModel(get()) }
    single<AppNavigator> { (navController: NavHostController) -> AppAppNavigatorImpl(navController) }
    single<TextResourceProvider> { TextResourceProviderImpl(get()) }
}