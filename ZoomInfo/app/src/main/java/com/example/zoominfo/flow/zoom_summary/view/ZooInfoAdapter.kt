package com.example.zoominfo.flow.zoom_summary.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zoominfo.api.response.ZoomInfo
import com.example.zoominfo.databinding.ItemZoomCategoryInfoBinding

interface IItemClickListener {
    fun onClick(item: ZoomInfo)
}

class ZoomInfoAdapter(private val mContext: Context,
                          private val mListener: IItemClickListener) : ListAdapter<ZoomInfo, ZoomInfoAdapter.ViewHolder>(sDiffUtil) {

    companion object {
        val sDiffUtil = object : DiffUtil.ItemCallback<ZoomInfo>() {
            override fun areItemsTheSame(
                oldItem: ZoomInfo,
                newItem: ZoomInfo
            ):Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ZoomInfo,
                newItem: ZoomInfo
            ):Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = ItemZoomCategoryInfoBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(mContext, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(getItem(position), mListener)
    }

    class ViewHolder(private val mContext: Context,
                     private val mBinding: ItemZoomCategoryInfoBinding) : RecyclerView.ViewHolder(mBinding.root) {

        fun binding(zoomInfoItem: ZoomInfo, listener: IItemClickListener) {
            mBinding.apply {
                Glide.with(mContext)
                    .load(zoomInfoItem.aPic01URL)
                    .into(ivPic)

                tvName.text = zoomInfoItem.aNameCh
                tvInfo.text = zoomInfoItem.aAlsoknown
                tvMemo.visibility = GONE

                root.setOnClickListener {
                    listener.onClick(zoomInfoItem)
                }
            }
        }
    }
}