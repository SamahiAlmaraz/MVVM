package com.example.cats.domain.useCase

import com.example.cats.domain.model.CatFactState
import com.example.cats.domain.repositories.CatFactRepository
import kotlinx.coroutines.flow.Flow

class GetCatRandomFactUseCaseImpl(
    private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): Flow<CatFactState> = catFactRepository.getCatRandomFact()
}