package com.example.branchlistproject.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.branchlistproject.model.BankBranch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlin.coroutines.CoroutineContext

@Composable
fun BranchList(modifier: Modifier = Modifier, branchesList: List<BankBranch>, onClick: (Int) -> Unit){
    var text = remember {
        mutableStateOf("Search")
    }
    var branchesListState = remember {
        mutableStateOf(branchesList)
    }

    Column (modifier = modifier.fillMaxSize()){
        TextField(modifier = Modifier.fillMaxWidth(), trailingIcon = { Icon(
            imageVector = Icons.Default.Search,
            contentDescription = ""
        )}, value = text.value, onValueChange = {
            text.value = it
            var searchedList = branchesListState.value.filter { it.name.uppercase().contains(text.value.trim().uppercase())}
            if (searchedList.size > 0)
                branchesListState.value = searchedList
            if (it.length == 0)
                branchesListState.value = branchesList
        })
        LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(15.dp), contentPadding = PaddingValues(10.dp)){
            items(branchesListState.value){
                BranchCard(bankBranch = it, onClick = onClick)
            }
        }
    }

}