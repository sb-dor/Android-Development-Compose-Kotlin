package com.example.androiddevelopment.working_with_internet


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    // you can put anything in {postId} but we want to send data
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<CommentModelModel>


    @Headers("Accept: application/json", "Authorization : Bearer Token")
    @GET("priceslist/")      // query key is for setting parameters
    suspend fun getKorgarData(@Query("key") key: String): Any
}


object RetrofitWorking {

    suspend fun makeRequest() {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val apiService = retrofit.create(ApiService::class.java);

        val data = apiService.getComments(1);

        data.forEachIndexed { index, commentModelModel -> println("index: $index | name: ${commentModelModel.name}") }
    }

    suspend fun makeKorgerReq() {
        val retrofit = Retrofit.Builder().baseUrl("https://korgar.tj/avera-api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val apiService = retrofit.create(ApiService::class.java);

        val data = apiService.getKorgarData(KorgarKey.key)

        println("coming korgar data: $data")
    }

}