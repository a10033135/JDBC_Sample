package idv.fan.tibame.jdbc_sample.network

import idv.fan.tibame.jdbc_sample.model.Employee
import retrofit2.http.GET

// todo 2-1 : 定義 ApiInterface
interface ApiInterface {

    @GET("ExEmployeeServlet")
    suspend fun getEmployeeList(): List<Employee>

}