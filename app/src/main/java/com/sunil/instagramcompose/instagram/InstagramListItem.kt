package com.sunil.instagramcompose.instagram

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sunil.instagramcompose.R
import com.sunil.instagramcompose.data.model.InstagramPostData
import com.sunil.instagramcompose.theme.gray
import com.sunil.instagramcompose.theme.typography
import java.util.*


@Composable
fun InstagramListItem(post: InstagramPostData) {
    Column {
        ProfileInfoSection(post)
        InstagramImage(imageId = post.instagramImageId)
        InstagramIconSection()
        InstagramLikesSection(post)
        Text(
            text = "View all ${post.commentsCount} comments",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
            color = Color.Gray
        )
        Text(
            text = "${post.time} ago",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 8.dp),
            color = Color.Gray
        )
    }
}

@Composable
private fun InstagramLikesSection(post: InstagramPostData) {
    Row(
        modifier = Modifier.padding(start = 8.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            bitmap = imageResource(id = post.userImageId),
            modifier = Modifier.preferredSize(20.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Liked by ${post.user} and ${post.likesCount} others",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun InstagramIconSection() {
    Row {
        var fav by remember { mutableStateOf(false) }
        IconToggleButton(checked = fav, onCheckedChange = { fav = it }) {
            val icon = if (fav) Icons.Default.Favorite else Icons.Default.FavoriteBorder
            val tint = if (fav) Color.Red else MaterialTheme.colors.onBackground
            Icon(imageVector = icon, modifier = Modifier.preferredSize(44.dp), tint = tint)
        }
        IconToggleButton(checked = false, onCheckedChange = {}) {
            Icon(
                imageVector = vectorResource(id = R.drawable.ic_comment),
                modifier = Modifier.preferredSize(44.dp)
            )
        }
        IconToggleButton(checked = false, onCheckedChange = {}) {
            Icon(
                imageVector = vectorResource(id = R.drawable.ic_send),
                modifier = Modifier.preferredSize(44.dp)
            )
        }
    }
}

@Composable
private fun ProfileInfoSection(post: InstagramPostData) {
    var showPopup by remember { mutableStateOf(false) }
    val onPopupDismissed = { showPopup = false }

    val context = ContextAmbient.current
    Row(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            bitmap = imageResource(id = post.userImageId),
            modifier = Modifier.preferredSize(32.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        // Which ever element has weight defined will take most space available
        Text(
            text = post.user,
            style = typography.body1,
            modifier = Modifier.padding(8.dp).weight(1f),
            textAlign = TextAlign.Left
        )
        IconButton(onClick = { showPopup = true }) {
            Icon(imageVector = Icons.Default.MoreVert)
        }
        FullScreenDialog(showPopup, onPopupDismissed)
    }
}

@Composable
private fun InstagramImage(imageId: Int) {
    if (imageId != 0) {
        Image(
            bitmap = imageResource(id = imageId),
            modifier = Modifier.fillMaxWidth().preferredHeight(450.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun FullScreenDialog(showPopup: Boolean, onClose: () -> Unit) {
    if (showPopup) {
        Dialog(onDismissRequest = onClose) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                color = gray
            ) {
                Column() {
                    Text(
                        text = "Report...",
                        modifier = Modifier.padding(top = 20.dp,bottom = 10.dp,start = 14.dp,end = 14.dp),
                        color = Color.White,
                    )
                    Text(
                        "Turn on Post Notifications",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                    )
                    Text(
                        text = "Copy Link",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    )
                    Text(
                        text = "Share to...",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    )
                    Text(
                        text = "Unfollow",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    )
                    Text(
                        text = "Mute",
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp,bottom = 20.dp,start = 14.dp,end = 14.dp),
                    )
                }
            }
        }

    }
}

