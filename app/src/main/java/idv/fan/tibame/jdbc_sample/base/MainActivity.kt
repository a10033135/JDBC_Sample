package idv.fan.tibame.jdbc_sample.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import idv.fan.tibame.jdbc_sample.ui.screen.employeeDetail.employeeScreenRoute
import idv.fan.tibame.jdbc_sample.ui.screen.employeeDetail.generateEmployeeScreenRoute
import idv.fan.tibame.jdbc_sample.ui.screen.home.HOME_SCREEN_KEY_ID
import idv.fan.tibame.jdbc_sample.ui.screen.home.HomeRoute
import idv.fan.tibame.jdbc_sample.ui.screen.home.homeScreenRoute
import idv.fan.tibame.jdbc_sample.ui.theme.JDBC_SampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold { innerPadding ->
                ExNavHost(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }
    }
}

// todo 1.運用官方元件時，建議加上可辨識的命名，例如：[Ex]NavHost，以利區開官方元件與自定義元件
@Composable
fun ExNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HOME_SCREEN_KEY_ID
    ) {
        homeScreenRoute(navigateToEmployeeDetail = { navController.navigate(generateEmployeeScreenRoute(it)) })
        employeeScreenRoute()

    }

}
