package com.example.birdscountingapp.model

class BirdCounter {
    var birdsSeen: Int = 0
        private set

    fun seeBird() = birdsSeen++

    fun resetBirdCount() {
        birdsSeen = 0
    }
}