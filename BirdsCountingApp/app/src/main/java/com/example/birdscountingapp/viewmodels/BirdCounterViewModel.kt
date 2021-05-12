package com.example.birdscountingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.birdscountingapp.model.BirdCounter

class BirdCounterViewModel(private val birdCounter: BirdCounter) : ViewModel() {

    private val _birdsSeen = MutableLiveData(birdCounter.birdsSeen)
    val birdsSeen: LiveData<Int> = _birdsSeen

    fun seeBird() {
        birdCounter.seeBird()
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun getBirdCounter() : Int {
       return birdCounter.birdsSeen
    }

    fun resetBirdCounter() {
        birdCounter.resetBirdCount()
    }

}