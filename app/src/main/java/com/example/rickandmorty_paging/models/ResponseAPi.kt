package com.example.rickandmorty_paging.models


import com.google.gson.annotations.SerializedName

data class ResponseAPi(
    @SerializedName("results")
    val results: List<RickyMorty>
)