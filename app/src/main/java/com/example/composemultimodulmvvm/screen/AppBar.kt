package com.example.composemultimodulmvvm.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composemultimodulmvvm.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppMainScreen(context:Context){
        TopAppBar(
            title = {
                Text(text = "Dogs")
            },
            actions = {
                IconButton(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Bandone23"))
                    context.startActivity(intent)
                }) {
                    Icon(painter = painterResource(id = R.drawable.icons_github), contentDescription = "Github",
                        modifier = Modifier
                            .width(48.dp)
                            .height(32.dp), )
                }
            }
        )

    }
