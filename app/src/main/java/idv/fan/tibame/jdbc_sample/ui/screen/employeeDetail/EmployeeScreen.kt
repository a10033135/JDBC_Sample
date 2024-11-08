package idv.fan.tibame.jdbc_sample.ui.screen.employeeDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import idv.fan.tibame.jdbc_sample.model.Employee

@Composable
fun EmployeeRoute(viewModel: EmployeeViewModel = viewModel()) {
    val employee by viewModel.employee.collectAsState()
    EmployeeScreen(employee)
}

@Preview
@Composable
fun PreviewEmployeeScreen() {
    EmployeeScreen(Employee("1", "王小明", "工程師"))
}

@Composable
fun EmployeeScreen(employee: Employee) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "員工編號：${employee.no}")
            Text(text = "員工職稱：${employee.job}")
            Text(text = "員工姓名：${employee.name}")
        }
    }


}