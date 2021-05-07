package com.czerny.publisher.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HomePageViewModel : ViewModel(){

    var editableList: MutableList<MockData> = mutableListOf()

    private val _homeProduct = MutableLiveData<List<MockData>>() //w2p2
    val homeProduct: LiveData<List<MockData>>
        get() = _homeProduct

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)

}