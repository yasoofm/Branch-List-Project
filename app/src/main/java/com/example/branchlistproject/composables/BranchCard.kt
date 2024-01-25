package com.example.branchlistproject.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.branchlistproject.R
import com.example.branchlistproject.model.BankBranch
import com.example.branchlistproject.model.Type
import com.example.branchlistproject.ui.theme.BranchListProjectTheme

@Composable
fun BranchCard(modifier: Modifier = Modifier, bankBranch: BankBranch, onClick: (Int) -> Unit){
    val favorite = remember {
        mutableStateOf(bankBranch.favorite)
    }
    Card (modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .clickable { onClick(bankBranch.id) },
        colors = CardDefaults.cardColors(containerColor = Color.White)){
        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier.width(100.dp)){
                Image(modifier = Modifier.fillMaxHeight(),painter = painterResource(id = bankBranch.imageURI), contentDescription = "Branch", alignment = Alignment.Center, contentScale = ContentScale.FillHeight)
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceAround) {
                Text(text = bankBranch.name)
                Row(modifier = Modifier.width(170.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = bankBranch.workingHours)
                    Text(text = "${bankBranch.type}")
                }
            }
            IconButton(onClick = { onFavClick(favorite, branch = bankBranch) }) {
                if(favorite.value) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Star",
                        tint = com.example.branchlistproject.ui.theme.Gold
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Star",
                        tint = com.example.branchlistproject.ui.theme.Disabled
                    )
                }
            }
            Spacer(modifier = Modifier)
        }
    }
}
fun onFavClick(favorite: MutableState<Boolean>, branch: BankBranch){
    favorite.value = !favorite.value
    branch.favorite = favorite.value
}

