package com.example.androiddevelopment.database.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevelopment.database.presentation.mvvm.LocalDatabaseViewModel

@Composable
fun LocalDatabasePage(localDatabaseViewModel: LocalDatabaseViewModel = viewModel()) {

    val currentState by localDatabaseViewModel.uiState.collectAsState();

    val textField = remember {
        mutableStateOf("")
    }

    localDatabaseViewModel.initLocalDatabase(context = LocalContext.current)


    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            item {

                Spacer(modifier = Modifier.height(15.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    TextField(
                        value = textField.value,
                        onValueChange = { textField.value = it })
                }
                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    ElevatedButton(onClick = {

                        val success = localDatabaseViewModel.addWordFunc(textField.value)

                        if (success) textField.value = ""

                    }) {
                        Text(text = "Add")
                    }
                }
            }

            itemsIndexed(currentState.words) { index, item ->
                Text(text = item.text)
            }
        }
    }

}