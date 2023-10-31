package com.example.zoominfo.flow.zoom_info_detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.zoominfo.databinding.FragmentZooDetailBinding

class ZooDetailFragment : Fragment() {

    // Arguments
    private val args: ZooDetailFragmentArgs by navArgs()
    // Binding
    private val mBinding: FragmentZooDetailBinding by lazy {
        FragmentZooDetailBinding.inflate(layoutInflater)
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
    }

    private fun initView() {
        mBinding.apply {
            tvToolbarTitle.text = args.nameCh
            tvNameCh.text = args.nameCh
            tvNameEn.text = args.nameEn
            tvAlsoKnown.text = args.alsoKnown
            tvDistribution.text = args.distribution
            tvFeature.text = args.feature
            tvBehavior.text = args.behavior
            tvLastUpdate.text = args.lastUpdate

            Glide.with(requireContext())
                .load(args.picUrl)
                .into(ivPic)

            ivToolBarBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}