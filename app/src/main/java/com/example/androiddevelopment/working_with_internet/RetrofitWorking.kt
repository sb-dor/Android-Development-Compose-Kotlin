package com.example.androiddevelopment.working_with_internet


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    // you can put anything in {postId} but we want to send data
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<CommentModelModel>
}


object RetrofitWorking {

    suspend fun makeRequest() {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val apiService = retrofit.create(ApiService::class.java);

        val data = apiService.getComments(1);

        data.forEachIndexed { index, commentModelModel -> println("index: $index | name: ${commentModelModel.name}") }
    }

}