package com.sunil.instagramcompose.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.sunil.instagramcompose.data.model.InstagramPostData


@Composable
fun GridListItem(
    item: InstagramPostData,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.height(100.dp).padding(2.dp)
    ) {
        Column(modifier = Modifier.clickable(onClick = {})) {
            val image = imageResource(item.instagramImageId)
            Image(
                bitmap = image,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .preferredHeight(100.dp)
                    .fillMaxWidth()
            )
        }
    }
}
