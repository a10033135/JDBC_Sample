package idv.fan.tibame.jdbc_sample.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import idv.fan.tibame.jdbc_sample.model.Employee
import idv.fan.tibame.jdbc_sample.ui.component.ExCardItem
import idv.fan.tibame.jdbc_sample.ui.component.ExLoadingProgress

// todo 4 : 區分 HomeScreen / HomeViewModel ，在 HomeRoute 中組合
@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(),
    onItemClick: (Employee) -> Unit = {}
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val employeeList by viewModel.employeeList.collectAsState()
    HomeScreen(
        isLoading = isLoading,
        employeeList = employeeList,
        onItemClick = onItemClick
    )
}


// todo 5 : 記得 @Preview 要加 Private 避免誤用
@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        isLoading = true,
        employeeList = listOf(
            Employee("1", "王小明", "工程師"),
            Employee("2", "陳小華", "設計師"),
            Employee("3", "李小強", "經理")
        )
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean = true,
    employeeList: List<Employee> = listOf(),
    onItemClick: (Employee) -> Unit = {}
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isLoading) {
                ExLoadingProgress(
                    modifier = Modifier
                        .zIndex(1f)
                        .align(Alignment.Center)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 24.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(employeeList) {
                    ExCardItem(
                        modifier = Modifier.clickable { onItemClick(it) },
                        no = it.no.toString(),
                        name = it.name ?: "",
                        job = it.job ?: ""
                    )
                }
            }
        }
    }
}