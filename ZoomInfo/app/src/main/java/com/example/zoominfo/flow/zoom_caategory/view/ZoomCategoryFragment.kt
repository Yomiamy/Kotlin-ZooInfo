package com.example.zoominfo.flow.zoom_caategory.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoominfo.api.response.ZoomCategoryInfoItem
import com.example.zoominfo.databinding.FragmentZoomCategoryBinding
import com.example.zoominfo.flow.zoom_caategory.viewmodel.ZoomCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ZoomCategoryFragment : Fragment(), IItemClickListener {

    // ViewModel
    private val mViewModel: ZoomCategoryViewModel by viewModels()
    // Binding
    private val mBinding: FragmentZoomCategoryBinding by lazy {
        FragmentZoomCategoryBinding.inflate(layoutInflater)
    }
    // Adapter
    private lateinit var mAdapter: ZoomCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
        initData()
    }

    private fun initView() {
        mAdapter = ZoomCategoryAdapter(requireContext(), this)

        mBinding.rvCategoryList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ZoomCategoryFragment.mAdapter
        }
    }

    private fun initObserver() {
        mViewModel.zoomCategoryItems.observe(viewLifecycleOwner) { zoomCategoryItems ->
            zoomCategoryItems?.let {zoomCategoryItems ->
                mBinding.pbProgress.visibility = GONE
                mAdapter.submitList(zoomCategoryItems)
            }
        }
    }

    private fun initData() {
        mBinding.pbProgress.visibility = VISIBLE
        mViewModel.fetchZoomCategory()
    }

    // --- IItemClickListener
    override fun onClick(item: ZoomCategoryInfoItem) {
        val directions = ZoomCategoryFragmentDirections.actionZoomCategoryToZoomSummary(
            item.eName,
            item.ePicURL,
            item.eInfo,
            item.eMemo,
            item.eCategory,
            item.eURL)
        findNavController().navigate(directions)
    }
}