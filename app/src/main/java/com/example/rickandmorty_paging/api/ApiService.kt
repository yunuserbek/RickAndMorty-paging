package com.example.rickandmorty_paging.api

import com.example.rickandmorty_paging.models.ResponseAPi
import com.example.rickandmorty_paging.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page:Int
    ):Response<ResponseAPi>
}