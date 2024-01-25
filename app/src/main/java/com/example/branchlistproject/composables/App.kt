package com.example.branchlistproject.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.branchlistproject.ui.theme.DarkGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(modifier: Modifier = Modifier){
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {
        TopAppBar(title = { Text(text = "AppBar")},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = DarkGreen,
                titleContentColor = Color.White)
        )}) {
            BranchNavHost(modifier = Modifier.padding(it))
    }
}