package com.example.quranapp.adapters.surahdetails

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.data.models.Ayah
import com.example.quranapp.data.models.Data
import com.example.quranapp.databinding.SurahDetailLayoutBinding

class SurahDetails : RecyclerView.Adapter<SurahDetails.Holder>() {

    var list: List<Ayah> = emptyList()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding=SurahDetailLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return Holder(binding)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])

    }
    inner class Holder(val binding: SurahDetailLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ayah: Ayah){
            val size=list.size

            for (i in 0..size){

                binding.ayaNo.text= (adapterPosition+1).toString()
            }
            binding.arabicText.text=ayah.text

        }
    }
}