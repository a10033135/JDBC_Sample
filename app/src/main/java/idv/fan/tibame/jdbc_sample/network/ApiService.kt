package idv.fan.tibame.jdbc_sample.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import idv.fan.tibame.jdbc_sample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

// todo 2: 目前主流為 Retrofit + OkHttp + Gson
object ApiService {

    // todo 3-3: 透過 BuildConfig 定義 BASE_URL
    private val BASE_URL = BuildConfig.BASE_URL

    private val gson: Gson by lazy { GsonBuilder().create() }

    private val okHttp by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY  // 加入詳細的請求/回應日誌
            })
            .addInterceptor { chain ->
                val request = chain.request()
                Timber.d("URL: ${request.url}")
                Timber.d("Method: ${request.method}")
                Timber.d("Headers: ${request.headers}")

                val response = chain.proceed(request)
                Timber.d("Response Code: ${response.code}")
                Timber.d("Response Message: ${response.message}")
                response
            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttp)
            .build()
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }


}