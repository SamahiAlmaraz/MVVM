package com.example.cats.domain.repositories

import com.example.cats.domain.model.CatFactState
import kotlinx.coroutines.flow.Flow

interface CatFactRepository {
        suspend fun getCatRandomFact(): Flow<CatFactState>
    }