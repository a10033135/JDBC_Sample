package idv.fan.tibame.jdbc_sample.model

import com.google.gson.annotations.SerializedName

// todo 5 宣告 Response 的資料類別時，需 annotation @SerializedName
data class Employee(
    @SerializedName("no") val no: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("job") val job: String? = null
)