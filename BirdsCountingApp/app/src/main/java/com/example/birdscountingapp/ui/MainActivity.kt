package com.example.birdscountingapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.birdscountingapp.R
import com.example.birdscountingapp.databinding.ActivityMainBinding
import com.example.birdscountingapp.preferences.PreferenceManager
import com.example.birdscountingapp.utilities.getBirdColor
import com.example.birdscountingapp.viewmodels.BirdCounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<BirdCounterViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            it.bRedBirdsSeen.setOnClickListener {
                seeRedBird()
            }
            it.bBlueBirdsSeen.setOnClickListener {
                seeBlueBird()
            }
            it.bGreenBirdsSeen.setOnClickListener {
                seeGreenBird()
            }
            it.bYellowBirdsSeen.setOnClickListener {
                seeYellowBird()
            }
            it.bReset.setOnClickListener {
                resetCounterAndColor()
            }
        }

        initializeBirdCounterAndColor()
        setContentView(binding.root)

        viewModel.birdsSeen.observe(this, { binding.tvCounter.text = it.toString()})

    }

    private fun initializeBirdCounterAndColor() {
        val preferenceManager = PreferenceManager()
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()

        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun updateBirdCounterAndColor(birdCounter: Int, birdColor: String) {
        binding.tvCounter.text = "$birdCounter"
        binding.tvCounter.setBackgroundResource(getBirdColor(birdColor))
    }

    private fun resetCounterAndColor() {
        viewModel.resetBirdCounter()
        val preferenceManager = PreferenceManager()
        preferenceManager.resetBirdCounterAndColor()
        updateBirdCounterAndColor(0, "")
    }

    private fun seeRedBird() {
        viewModel.seeBird()
        val counter = viewModel.getBirdCounter()
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("red", counter)
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun seeBlueBird() {
        viewModel.seeBird()
        val counter = viewModel.getBirdCounter()
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("blue", counter)
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun seeGreenBird() {
        viewModel.seeBird()
        val counter = viewModel.getBirdCounter()
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("green", counter)
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun seeYellowBird() {
        viewModel.seeBird()
        val counter = viewModel.getBirdCounter()
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("yellow", counter)
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }
}