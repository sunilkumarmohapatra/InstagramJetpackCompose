package com.sunil.instagramcompose.instagram

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sunil.instagramcompose.data.InstagramDummyData
import com.sunil.instagramcompose.data.model.InstagramPostData
import com.sunil.instagramcompose.theme.instagramGradient
import com.sunil.instagramcompose.theme.typography

@Composable
fun InstagramStories() {
    val posts = remember { InstagramDummyData.instagramList }
    LazyRow(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
        items(posts) {
            StoryListItem(post = it)
        }
    }
}

@Composable
fun StoryListItem(post: InstagramPostData) {
    val imageModifier =
        if (post.id == 1) {
            Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp,bottom = 4.dp)
                .preferredHeight(70.dp)
                .preferredWidth(70.dp)
                .clip(CircleShape)
        } else {
            Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp,bottom = 4.dp)
                .preferredHeight(70.dp)
                .preferredWidth(70.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 3.dp,
                        brush = Brush.linearGradient(
                            colors = instagramGradient,
                            start = Offset(
                                0f,
                                0f
                            ),
                            end = Offset(
                                100f,
                                100f
                            )
                        )
                    )
                )
        }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            bitmap = imageResource(id = post.userImageId),
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Text(text = post.user, style = typography.caption, textAlign = TextAlign.Center)
    }
}
