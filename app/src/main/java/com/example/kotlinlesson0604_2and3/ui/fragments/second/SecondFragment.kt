package com.example.kotlinlesson0604_2and3.ui.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlesson0604_2and3.R
import com.example.kotlinlesson0604_2and3.databinding.FragmentSecondBinding
import com.example.kotlinlesson0604_2and3.date.core.UIState
import com.example.kotlinlesson0604_2and3.ui.fragments.second.adapter.ViewAdapter

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: ViewAdapter
    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[SecondViewModel::class.java]
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ViewAdapter()
        binding.RecyclerView.adapter = adapter
        viewModel.getAllPerson()

        viewModel.mutableLiveData.observe(requireActivity()) { state ->
            when (state) {
                is UIState.Loading -> {
                }
                is UIState.Error -> {
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
                is UIState.Success -> {
                    adapter.setItems(state.data)
                }
            }
        }
    }
}