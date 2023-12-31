package com.example.zoominfo.flow.zoom_summary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zoominfo.api.response.ZoomInfo
import com.example.zoominfo.flow.zoom_summary.repository.ZooSummaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZooSummaryViewModel @Inject constructor(private val repository: ZooSummaryRepository) :
    ViewModel() {

    var filteredZoomInfoList: MutableLiveData<List<ZoomInfo>?> = MutableLiveData(null)

    fun fetchZoomListByLocation(location: String) {
        viewModelScope.launch {
            repository.fetchAllZoomList()?.let { zoomInfoList ->
                filteredZoomInfoList.value = zoomInfoList.filter { zoomInfo -> zoomInfo.aLocation.contains(location) }
            }
        }
    }
}