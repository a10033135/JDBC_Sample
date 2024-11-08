package idv.fan.tibame.jdbc_sample.ui.screen.employeeDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import idv.fan.tibame.jdbc_sample.model.Employee
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EmployeeViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val gson = Gson()
    private val employeeJson = checkNotNull(savedStateHandle.get<String>("employee"))

    private val _employee = MutableStateFlow(gson.fromJson(employeeJson, Employee::class.java))
    val employee = _employee.asStateFlow()


}