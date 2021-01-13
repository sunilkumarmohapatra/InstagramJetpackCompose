package com.sunil.instagramcompose.search

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sunil.instagramcompose.R
import com.sunil.instagramcompose.data.InstagramDummyData
import com.sunil.instagramcompose.theme.gray

import com.sunil.instagramcompose.theme.typography
import java.util.Stack


@Composable
fun SearchHome(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = 8.dp,
                navigationIcon = {
                    IconButton(onClick = { onBack }) {
                        Icon(imageVector = Icons.Default.ArrowBack)
                    }
                },
                actions = {
                    var email by remember { mutableStateOf(TextFieldValue("")) }
                    CustomTextField(
                        modifier = Modifier.fillMaxWidth().height(40.dp).background(
                            color = gray,
                            shape = CircleShape
                        )
                            .padding(horizontal = 12.dp, vertical = 10.dp),
                        leadingIcon = { Icon(Icons.Filled.Search) }
                    )
                    IconButton(onClick = {}) {
                        Icon(imageVector = vectorResource(id = R.drawable.ic_instagram))
                    }
                }
            )
        },
        bodyContent = {
            InstagramSearchContent()
        }
    )
}

@Composable
fun InstagramSearchContent() {
    Column {
        InstagramSearchList()
    }
}

@Composable
fun InstagramSearchList() {
    val posts = remember { InstagramDummyData.instagramList.filter { it.instagramImageId != 0 } }
    ScrollableColumn {
        VerticalGrid(columns = 3) {
            posts.forEach {
                GridListItem(item = it)
            }
        }

    }
}

@Composable
private fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable() () -> Unit)? = null
) {
    val state = savedInstanceState(saver = TextFieldValue.Saver) { TextFieldValue() }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (leadingIcon != null) {
            leadingIcon()
        }
    }
}
