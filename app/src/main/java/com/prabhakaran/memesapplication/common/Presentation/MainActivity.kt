package com.prabhakaran.memesapplication.common.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prabhakaran.memesapplication.R
import com.prabhakaran.memesapplication.feature.memes.presentation.ItemFragment
import com.prabhakaran.memesapplication.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ItemFragment.newInstance())
                .commitNow()
        }
    }
}