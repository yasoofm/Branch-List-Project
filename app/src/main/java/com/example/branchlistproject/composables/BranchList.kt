package com.example.branchlistproject.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.branchlistproject.model.BankBranch
@Composable
fun BranchList(modifier: Modifier = Modifier, branchesList: List<BankBranch>, onClick: (Int) -> Unit){
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(10.dp)){
        items(branchesList){
            BranchCard(bankBranch = it, onClick = onClick)
        }
    }
}