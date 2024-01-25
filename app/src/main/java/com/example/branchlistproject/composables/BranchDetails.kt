package com.example.branchlistproject.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.branchlistproject.model.BankBranch

@Composable
fun BranchDetails(branch: BankBranch){
    Text(text = branch.name)
}