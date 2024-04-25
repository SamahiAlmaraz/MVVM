package com.example.cats.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cats.domain.model.CatFactState
import com.example.cats.presentation.ui.composables.CatFactCard
import kotlinx.coroutines.flow.Flow


@Composable
fun CatFactScreen(
    catFact: Flow<CatFactState>,
    onClick: () -> Unit
) {
    val catFactStates: CatFactState
            by catFact.collectAsStateWithLifecycle(initialValue = CatFactState.Loading)



    when (catFactStates) {
        is CatFactState.Loading -> CatFactCard(
            text = "Click to Get a Cat Fact!",
            onClick = onClick)
        is CatFactState.CatFactData -> CatFactCard(
            text = (catFactStates as CatFactState.CatFactData).fact.text,
            onClick = onClick)
        else -> CatFactCard(text = "Nothing to show", onClick={})
    }
}