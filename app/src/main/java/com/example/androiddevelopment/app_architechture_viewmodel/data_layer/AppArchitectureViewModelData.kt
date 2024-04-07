package com.example.androiddevelopment.app_architechture_viewmodel.data_layer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.androiddevelopment.app_architechture.model.Dessert

data class AppArchitectureViewModelData(
    var dessert: SnapshotStateList<Dessert> = mutableStateListOf(),
    var tempDessert: Dessert? = null

)
