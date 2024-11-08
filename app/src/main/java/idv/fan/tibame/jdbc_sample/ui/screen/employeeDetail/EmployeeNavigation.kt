package idv.fan.tibame.jdbc_sample.ui.screen.employeeDetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import idv.fan.tibame.jdbc_sample.model.Employee

val EMPLOYEE_SCREEN_KEY_ID = "employee"

val EMPLOYEE_SCREEN_ARGS_KEY = "employee"

val EMPLOYEE_SCREEN_ROUTE = "$EMPLOYEE_SCREEN_KEY_ID?$EMPLOYEE_SCREEN_ARGS_KEY={$EMPLOYEE_SCREEN_ARGS_KEY}"

fun generateEmployeeScreenRoute(employee: Employee): String {
    val jsonEmployee = Gson().toJson(employee)
    return "$EMPLOYEE_SCREEN_KEY_ID?$EMPLOYEE_SCREEN_ARGS_KEY=$jsonEmployee"
}

fun NavGraphBuilder.employeeScreenRoute() {
    composable(
        route = EMPLOYEE_SCREEN_ROUTE,
        arguments = listOf(
            navArgument(EMPLOYEE_SCREEN_ARGS_KEY) { type = NavType.StringType }
        )
    ) { backStackEntry ->
        EmployeeRoute()
    }
}