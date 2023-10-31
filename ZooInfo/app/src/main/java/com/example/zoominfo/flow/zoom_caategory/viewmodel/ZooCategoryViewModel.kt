package com.example.zoominfo.flow.zoom_caategory.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zoominfo.api.response.ZoomCategoryInfoItem
import com.example.zoominfo.flow.zoom_caategory.repository.ZooCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZooCategoryViewModel @Inject constructor(private val repository: ZooCategoryRepository): ViewModel() {

    var zoomCategoryItems:MutableLiveData<List<ZoomCategoryInfoItem>?> = MutableLiveData(null)

    fun fetchZoomCategory() {
        viewModelScope.launch {
            repository.fetchZoomCategory()?.let { zoomCategoryInfoItems ->
                zoomCategoryItems.value = zoomCategoryInfoItems
            }
        }
    }
}