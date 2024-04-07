package com.example.androiddevelopment.app_architechture_viewmodel.ui.view_model

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevelopment.app_architechture.data.DataSource
import com.example.androiddevelopment.app_architechture.model.Dessert
import com.example.androiddevelopment.app_architechture_viewmodel.data_layer.AppArchitectureViewModelData
import kotlin.random.Random

class AppArchitectureViewModel : ViewModel() {

    val uiState = mutableStateOf(AppArchitectureViewModelData())


    init {
        generateRandom();
    }

    fun generateRandom() {
        val random = Random.nextInt(0, DataSource.listOfDesserts.size);
        val tempValue = DataSource.listOfDesserts[random];
        uiState.value = uiState.value.copy(tempDessert = tempValue);
    }

    fun getTotal(): Int {
        var total = 0;
        for (n in uiState.value.dessert) {
            total += n.price;
        }
        return total;
    }

    fun addToList() {
        if (uiState.value.tempDessert == null) return;
        uiState.value.dessert.add(uiState.value.tempDessert!!)
        uiState.value = uiState.value.copy(dessert = uiState.value.dessert)
    }

}