package com.example.quranapp.adapters.surah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.data.models.Data
import com.example.quranapp.data.models.SurahModel
import com.example.quranapp.databinding.SurahLayoutBinding

class SurahAdapter : RecyclerView.Adapter<SurahAdapter.Holder>() {

    var list: List<Data> = emptyList()
    lateinit var onClick:onClickSurah


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding=SurahLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    inner class Holder(val binding: SurahLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: Data){
        binding.apply {
        surahNumber.text= surah.number.toString()
            arabicName.text=surah.name
            totalAya.text= surah.numberOfAyahs.toString()
            englishName.text=surah.englishName

            root.setOnClickListener{
                onClick.onClick(list[adapterPosition])
            }
        }
        }
    }

}