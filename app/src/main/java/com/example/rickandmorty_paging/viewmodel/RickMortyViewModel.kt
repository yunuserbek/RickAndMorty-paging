package com.example.rickandmorty_paging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmorty_paging.api.ApiService
import com.example.rickandmorty_paging.paging.RickyMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel@Inject constructor(private val apiService: ApiService):ViewModel() {


    val listData = Pager(PagingConfig(pageSize = 1)){
        RickyMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}