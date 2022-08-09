package com.example.rickandmorty_paging

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmorty_paging.adapter.RickyMortyPagedAdapter
import com.example.rickandmorty_paging.databinding.ActivityMainBinding
import com.example.rickandmorty_paging.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter:RickyMortyPagedAdapter
    private val viewModel :RickMortyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRv()
        loadingData()

    }

    private fun loadingData() {
        lifecycleScope.launchWhenStarted {
            viewModel.listData.collect {pagingData->
                mAdapter.submitData(pagingData)

            }
        }
    }

    private fun setupRv(){
        mAdapter = RickyMortyPagedAdapter()
        binding.rickyRV.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rickyRV.adapter = mAdapter
        binding.rickyRV.setHasFixedSize(true)

    }
}