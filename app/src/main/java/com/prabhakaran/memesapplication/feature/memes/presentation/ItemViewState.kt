package com.prabhakaran.memesapplication.feature.memes.presentation

import com.prabhakaran.memesapplication.common.data.model.Data
import com.prabhakaran.memesapplication.common.data.model.Memes

sealed class ItemViewState{

    object Loading : ItemViewState()
    data class Content( val memes : Memes) : ItemViewState()
    data class Error( val error : String) : ItemViewState()

}
