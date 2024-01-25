package com.example.branchlistproject.composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.example.branchlistproject.R
import com.example.branchlistproject.model.BankBranch

@Composable
fun BranchDetails(branch: BankBranch){
    val localUriHandler = LocalUriHandler.current
    Row {
        Box(modifier = Modifier.width(100.dp)){
            Image(modifier = Modifier.fillMaxHeight(),painter = painterResource(id = branch.imageURI), contentDescription = "Branch", alignment = Alignment.Center, contentScale = ContentScale.FillHeight)
        }
 Column(modifier = Modifier
     .fillMaxSize()
     .padding(vertical = 8.dp, horizontal = 16.dp))


    {
     if(branch.favorite){
         Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
             Icon(modifier = Modifier.size(50.dp), painter = painterResource(id = R.drawable.star), contentDescription = "Start", tint = com.example.branchlistproject.ui.theme.Gold)
         }
     } else {
         Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
             Icon(modifier = Modifier.size(50.dp), painter = painterResource(id = R.drawable.star), contentDescription = "Start", tint = com.example.branchlistproject.ui.theme.Disabled)
         }
     }
     Spacer(modifier = Modifier.height(100.dp))
     Text(text = branch.name)
     Text(text = branch.workingHours)
     Text(text = "${branch.type}")
     Text(text =  branch.address)
     Text(text = branch.phone)

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        ClickableText(text = AnnotatedString("Location")){
            localUriHandler.openUri(branch.location)
        }
        Icon(imageVector = Icons.Default.Place, contentDescription = null, tint = Color.Red)
    }
 }
}}