package com.example.kotlinlesson0604_2and3.ui.fragments.second.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson0604_2and3.databinding.ItemViewBinding
import com.example.kotlinlesson0604_2and3.date.model.Person

class ViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(list[position])
    }
    override fun getItemCount(): Int {
        return list.size
    }
    class ViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(person: Person) {
            binding.txtName.text = person.name
            binding.txtAge.text = person.age.toString()
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setItems(people: List<Person>) {
        list.clear()
        list.addAll(people)
        notifyDataSetChanged()
    }
}