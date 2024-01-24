package com.example.branchlistproject.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BranchList(modifier: Modifier = Modifier){

    LazyColumn(){
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
        item { BranchCard() }
    }
}