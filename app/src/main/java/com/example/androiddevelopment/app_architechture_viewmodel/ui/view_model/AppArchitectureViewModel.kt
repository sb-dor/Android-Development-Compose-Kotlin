package com.example.androiddevelopment.app_architechture_viewmodel.ui.view_model

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevelopment.app_architechture.data.DataSource
import com.example.androiddevelopment.app_architechture.model.Dessert
import com.example.androiddevelopment.app_architechture_viewmodel.data_layer.AppArchitectureViewModelData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class AppArchitectureViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppArchitectureViewModelData())
    val uiState: StateFlow<AppArchitectureViewModelData> = _uiState.asStateFlow()


    init {
        generateRandom();
    }

    fun generateRandom() {
        val random = Random.nextInt(0, DataSource.listOfDesserts.size);
        val tempValue = DataSource.listOfDesserts[random];
        _uiState.update { currentState -> currentState.copy(tempDessert = tempValue) };
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
        _uiState.update { currentState -> currentState.copy(dessert = uiState.value.dessert) }
    }

}