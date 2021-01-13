package com.sunil.instagramcompose.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.core.content.ContextCompat
import com.sunil.instagramcompose.search.SearchHome
import com.sunil.instagramcompose.theme.ComposeCookBookTheme

class SearchActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        setContent {
            ComposeCookBookTheme {
                SearchHome{
                    onBackPressed()
                }
            }
        }
    }
    companion object {
        const val DARK_THEME = "darkTheme"
        fun newIntent(context: Context, isDarkTheme: Boolean) =
            Intent(context, SearchActivity::class.java).apply {
                putExtra(DARK_THEME, isDarkTheme)
            }
    }
}