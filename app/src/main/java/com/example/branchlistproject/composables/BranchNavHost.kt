package com.example.branchlistproject.composables

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.branchlistproject.model.BankBranch
import com.example.branchlistproject.model.Type
import com.example.branchlistproject.repo.BranchRepo

@Composable
fun BranchNavHost(modifier: Modifier = Modifier,
                  navController: NavHostController = rememberNavController(),
                  startDestination: String = "branchesList") {
    val branchesList = BranchRepo.branchList
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination){
        composable("branchesList"){
            BranchList(branchesList = branchesList, onClick = {
                Log.i("CHECK_ID", "$it")
                navController.navigate("branchDetails/$it")})
        }
        composable("branchDetails/{branchId}"){
            val branchId = it.arguments?.getString("branchId")?.toInt()
            val branch = branchesList.find { branchId == it.id }
            BranchDetails(branch = branch ?: BankBranch(0, "None", Type.ATM, "", "", "", "", 0))
        }
    }
}