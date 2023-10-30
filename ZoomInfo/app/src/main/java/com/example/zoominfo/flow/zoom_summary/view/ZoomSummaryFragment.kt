package com.example.zoominfo.flow.zoom_summary.view

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.zoominfo.R
import com.example.zoominfo.api.response.ZoomInfo
import com.example.zoominfo.databinding.FragmentZoomSummaryBinding
import com.example.zoominfo.flow.zoom_summary.viewmodel.ZoomSummaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint

    // Arguments
    private val args: ZoomSummaryFragmentArgs by navArgs()
    // ViewModel
    private val mViewModel: ZoomSummaryViewModel by viewModels()
    // Binding
    private val mBinding: FragmentZoomSummaryBinding by lazy {
        FragmentZoomSummaryBinding.inflate(layoutInflater)
    }
    // Adapter
    private lateinit var mAdapter: ZoomInfoAdapter

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
        mAdapter = ZoomInfoAdapter(requireContext(), this)

        mBinding.apply {
            tvToolbarTitle.text = args.eName
            tvInfo.text = args.eInfo
            tvMemo.text = args.eMemo.ifBlank { getString(R.string.no_memo_info) }
            tvCategory.text = args.eCategory


            rvZoomList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = this@ZoomSummaryFragment.mAdapter
            }

            Glide.with(requireContext())
                .load(args.ePicUrl)
                .into(ivSummaryPic)

            tvUrl.setOnClickListener {
                try {
                    startActivity(Intent(ACTION_VIEW, Uri.parse(args.eUrl)))
                } catch(e: Exception) {
                    e.printStackTrace()
                }
            }

            ivToolBarBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun initObserver() {
        mViewModel.filteredZoomInfoList.observe(viewLifecycleOwner) {filteredZoomInfoList ->
            filteredZoomInfoList?.let {
                mBinding.pbProgress.visibility = GONE
                mAdapter.submitList(filteredZoomInfoList)
            }
        }
    }

    private fun initData() {
        mBinding.pbProgress.visibility = VISIBLE

        mViewModel.fetchZoomListByLocation(args.eName)
    }

    }
}