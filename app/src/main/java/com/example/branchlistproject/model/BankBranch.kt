package com.example.branchlistproject.model

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class BankBranch(val id: Int, var name: String, var type: Type,
                      var address: String, var phone: String,
                      var workingHours: String, var location: String,
                      var imageURI: Int,
                      var favorite: Boolean =  false)
