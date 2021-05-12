package com.example.birdscountingapp.di

import com.example.birdscountingapp.model.BirdCounter
import com.example.birdscountingapp.viewmodels.BirdCounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { BirdCounter() }
}

val viewModelModule = module {
    viewModel { BirdCounterViewModel(get()) }
}