package com.example.zoominfo.flow.zoom_caategory.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zoominfo.R
import com.example.zoominfo.api.response.ZoomCategoryInfoItem
import com.example.zoominfo.databinding.ItemZoomCategoryInfoBinding

interface IItemClickListener {
    fun onClick(item: ZoomCategoryInfoItem)
}

class ZoomCategoryAdapter(private val mContext: Context,
                          private val mListener: IItemClickListener) : ListAdapter<ZoomCategoryInfoItem, ZoomCategoryAdapter.ViewHolder>(sDiffUtil) {

    companion object {
        val sDiffUtil = object : DiffUtil.ItemCallback<ZoomCategoryInfoItem>() {
            override fun areItemsTheSame(
                oldItem: ZoomCategoryInfoItem,
                newItem: ZoomCategoryInfoItem
            ):Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ZoomCategoryInfoItem,
                newItem: ZoomCategoryInfoItem
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

        fun binding(zoomCategoryInfoItem: ZoomCategoryInfoItem, listener: IItemClickListener) {
            mBinding.apply {
                Glide.with(mContext)
                    .load(zoomCategoryInfoItem.ePicURL)
                    .into(ivPic)

                tvName.text = zoomCategoryInfoItem.eName
                tvInfo.text = zoomCategoryInfoItem.eInfo
                tvMemo.text = zoomCategoryInfoItem.eMemo.ifBlank {
                        mContext.getString(R.string.no_memo_info)
                    }

                root.setOnClickListener {
                    listener.onClick(zoomCategoryInfoItem)
                }
            }
        }
    }
}