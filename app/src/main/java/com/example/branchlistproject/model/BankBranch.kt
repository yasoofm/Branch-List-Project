package com.example.branchlistproject.model

data class BankBranch(val id: Int, var name: String, var type: Type,
                      var address: String, var phone: String,
                      var workingHours: String, var location: String,
                      var imageURI: Int)
