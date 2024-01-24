package com.example.branchlistproject.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.branchlistproject.R
import com.example.branchlistproject.ui.theme.BranchListProjectTheme

@Composable
fun BranchCard(modifier: Modifier = Modifier){
    Card (modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)){
        Row {
            Box(modifier = Modifier.width(100.dp)){
                Image(modifier = Modifier.fillMaxHeight(),painter = painterResource(id = R.drawable.branch), contentDescription = "Branch", alignment = Alignment.Center, contentScale = ContentScale.FillHeight)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)) {
                Text(text = "Rawda Branch")
                Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "1:30 - 9:00")
                    Text(text = "Branch")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BranchCardPreview() {
    BranchListProjectTheme {
        BranchCard()
    }
}