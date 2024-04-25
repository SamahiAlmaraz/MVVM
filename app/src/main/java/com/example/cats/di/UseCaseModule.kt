package com.example.cats.di

import com.example.cats.domain.repositories.CatFactRepository
import com.example.cats.domain.useCase.GetCatRandomFactUseCase
import com.example.cats.domain.useCase.GetCatRandomFactUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCatRandomFact(
        catFactRepository: CatFactRepository
    ): GetCatRandomFactUseCase = GetCatRandomFactUseCaseImpl(catFactRepository)
}