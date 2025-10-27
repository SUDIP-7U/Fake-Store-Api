package com.example.fakerestfulapi.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fakerestfulapi.viewmodel.MainViewModel
import com.example.fakerestfulapi.VB.BaseFragment
import com.example.fakerestfulapi.data.ResponseProducts
import com.example.fakerestfulapi.databinding.FragmentProductBinding


class ProductFragment : BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    lateinit var productlist : ListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllProduct()

        viewModel.allProductResponse.observe(requireActivity()) { response ->

            productlist = ListAdapter(response.products as List<ResponseProducts.Product>?)

            val manager = GridLayoutManager(requireContext(), 2)
            binding.rcvslistitem.layoutManager = manager
            binding.rcvslistitem.adapter = productlist

        }


    }
}