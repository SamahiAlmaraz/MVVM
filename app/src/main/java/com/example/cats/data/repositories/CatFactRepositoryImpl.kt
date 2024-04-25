package com.example.cats.data.repositories

import com.example.cats.data.network.CatFactService
import com.example.cats.domain.model.CatFactState
import com.example.cats.domain.repositories.CatFactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor (
    private val catFactsService: CatFactService.CatFactsService
): CatFactRepository {
    override suspend fun getCatRandomFact(): Flow<CatFactState>{
        return try {
            val response = catFactsService.getCatRandomFact()
            val fact = response.body()
            return if (fact != null) flow{ emit(CatFactState.CatFactData(fact))  }
            else flow { emit(  CatFactState.Error(IOException("Data is null"))) }
        } catch (exception: Exception) {
             flow { emit(CatFactState.Error(exception)) }
        }
    }
}