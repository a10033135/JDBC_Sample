package idv.fan.tibame.jdbc_sample.ui.screen.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import idv.fan.tibame.jdbc_sample.model.Employee

// todo 3：抽出 Navigation 層，讓 HomeScreen 的邏輯可以獨立於此
const val HOME_SCREEN_KEY_ID = "home"

fun NavGraphBuilder.homeScreenRoute(
    navigateToEmployeeDetail: (Employee) -> Unit
) {
    composable(route = HOME_SCREEN_KEY_ID) {
        HomeRoute(onItemClick = navigateToEmployeeDetail)
    }
}