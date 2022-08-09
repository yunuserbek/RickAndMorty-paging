package com.example.rickandmorty_paging.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty_paging.adapter.RickyMortyPagedAdapter.*
import com.example.rickandmorty_paging.databinding.RickyMortyLayoutBinding
import com.example.rickandmorty_paging.models.RickyMorty

class RickyMortyPagedAdapter:PagingDataAdapter<RickyMorty, MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding:RickyMortyLayoutBinding):RecyclerView.ViewHolder(binding.root)

    companion object{
        val diffCallback = object :DiffUtil.ItemCallback<RickyMorty>(){
            override fun areItemsTheSame(oldItem: RickyMorty, newItem: RickyMorty): Boolean {
                return oldItem.id ==newItem.id
            }

            override fun areContentsTheSame(oldItem: RickyMorty, newItem: RickyMorty): Boolean {
               return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        //this method getItem() is form pagingDataAdapter
        holder.binding.apply {

            textview.text="${currentItem?.name}"
            val imageLink = currentItem?.image
            //here l
            imageView.load(imageLink){
                crossfade(true)
                crossfade(1000)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RickyMortyLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}