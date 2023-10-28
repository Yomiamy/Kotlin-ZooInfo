package com.example.zoominfo.flow.zoom_summary.view

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.zoominfo.R
import com.example.zoominfo.databinding.FragmentZoomSummaryBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
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
        mBinding.apply {
            tvToolbarTitle.text = args.eName
            tvInfo.text = args.eInfo
            tvMemo.text = args.eMemo.ifBlank { getString(R.string.no_memo_info) }
            tvCategory.text = args.eCategory

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
        // TODO: Not yet implemented
    }

    private fun initData() {
        // TODO: Not yet implemented
        Log.d("", "")
    }
}