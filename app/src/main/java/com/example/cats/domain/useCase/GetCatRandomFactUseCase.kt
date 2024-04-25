package com.example.cats.domain.useCase

import com.example.cats.domain.model.CatFactState
import kotlinx.coroutines.flow.Flow

interface GetCatRandomFactUseCase {
        suspend operator fun invoke(): Flow<CatFactState>
    }
