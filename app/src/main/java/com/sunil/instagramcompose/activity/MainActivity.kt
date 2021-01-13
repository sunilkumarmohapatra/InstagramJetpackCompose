package com.sunil.instagramcompose.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.setContent
import androidx.core.content.ContextCompat
import com.sunil.instagramcompose.theme.ComposeCookBookTheme
import com.sunil.instagramcompose.instagram.InstagramHome

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        setContent {
            ComposeCookBookTheme {
                InstagramHome()
            }
        }
    }
}

