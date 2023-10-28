package com.example.zoominfo.flow.zoom_summary.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.zoominfo.R
import com.example.zoominfo.databinding.FragmentZoomCategoryBinding
import com.example.zoominfo.databinding.FragmentZoomSummaryBinding

class ZoomSummaryFragment : Fragment() {

    // Arguments
    private val args: ZoomSummaryFragmentArgs by navArgs()
    // Binding
    private val mBinding: FragmentZoomSummaryBinding by lazy {
        FragmentZoomSummaryBinding.inflate(layoutInflater)
    }

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
        // TODO: Not yet implemented
    }

    private fun initObserver() {
        // TODO: Not yet implemented
    }

    private fun initData() {
        // TODO: Not yet implemented
        Log.d("", "")
    }
}