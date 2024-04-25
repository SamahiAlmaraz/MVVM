package com.example.cats.domain.model

sealed class CatFactState {
    object Init: CatFactState()
    object Loading:CatFactState()
    class CatFactData(val fact: Fact):CatFactState()
    class Error(val error:Throwable):CatFactState()
}