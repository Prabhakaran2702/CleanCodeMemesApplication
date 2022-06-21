package com.prabhakaran.memesapplication.feature.memes.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prabhakaran.memesapplication.feature.memes.business.MemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: MemeRepository) : ViewModel() {


    private val _postLiveData = MutableLiveData<ItemViewState>()

    val postLiveData : LiveData<ItemViewState>
        get() = _postLiveData


    fun loadData() {

        _postLiveData.postValue(ItemViewState.Loading)

        viewModelScope.launch {

            repository.getPost().let {

                if(it.isSuccessful) {
                    _postLiveData.postValue(ItemViewState.Content(it.body()!!))
                }
                else{
                    _postLiveData.postValue(ItemViewState.Error("Item not found"))
                }

            }

        }


    }


}