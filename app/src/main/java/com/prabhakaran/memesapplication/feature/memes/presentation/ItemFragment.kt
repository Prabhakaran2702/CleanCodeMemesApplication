package com.prabhakaran.memesapplication.feature.memes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prabhakaran.memesapplication.databinding.FragmentItemListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    private val viewModel : ItemViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentItemListBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadData()
        observeLiveData()

    }


    private fun observeLiveData(){

        viewModel.postLiveData.observe(viewLifecycleOwner){

            when(it){
                is ItemViewState.Loading -> {}
                is ItemViewState.Content -> {
                    if (binding.root is RecyclerView) {
                        with(binding.root) {
                            layoutManager =  LinearLayoutManager(context)
                            adapter = MyItemRecyclerViewAdapter(context,it.memes.data.memes)
                        }
                    } }

                is ItemViewState.Error -> {}
            }

        }

    }


    companion object {
        fun newInstance() = ItemFragment()
    }
}