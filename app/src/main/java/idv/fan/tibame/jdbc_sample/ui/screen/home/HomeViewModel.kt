package idv.fan.tibame.jdbc_sample.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idv.fan.tibame.jdbc_sample.model.Employee
import idv.fan.tibame.jdbc_sample.network.ApiInterface
import idv.fan.tibame.jdbc_sample.network.ApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _employeeList = MutableStateFlow(emptyList<Employee>())
    val employeeList = _employeeList.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000L)
            // todo 2-3 : 使用 ApiService 呼叫 getEmployeeList
            _employeeList.value = ApiService.create(ApiInterface::class.java).getEmployeeList()
            _isLoading.value = false
        }
    }
}