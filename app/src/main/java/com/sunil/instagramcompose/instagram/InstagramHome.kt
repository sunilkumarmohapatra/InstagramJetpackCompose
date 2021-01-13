package com.sunil.instagramcompose.instagram

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sunil.instagramcompose.data.InstagramDummyData
import com.sunil.instagramcompose.R
import com.sunil.instagramcompose.activity.SearchActivity


@Composable
fun InstagramHome() {
    val context = AmbientContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Instagram",
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        color = Color.White
                    )
                },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = 8.dp,
                actions = {
                    IconButton(onClick = {
                        context.startActivity(
                            SearchActivity.newIntent(context,true)
                        )
                    }) {
                        Icon(imageVector = vectorResource(id = R.drawable.ic_search))
                    }
                    Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp,bottom = 4.dp)
                    IconButton(onClick = {}) {
                        Icon(imageVector = vectorResource(id = R.drawable.ic_messenger))
                    }
                }
            )
        },
        bodyContent = {
            InstagramHomeContent()
        }
    )
}

@Composable
fun InstagramHomeContent() {
    Column {
        InstagramStories()
        Divider()
        InstagramPostsList()
    }
}

@Composable
fun InstagramPostsList() {
    val posts = remember { InstagramDummyData.instagramList.filter { it.instagramImageId != 0 } }
    LazyColumn {
        items(
            items = posts,
            itemContent = {
                InstagramListItem(post = it)
            })
    }
}

@Preview
@Composable
fun PreviewInstagramHome() {
    InstagramHome()
}