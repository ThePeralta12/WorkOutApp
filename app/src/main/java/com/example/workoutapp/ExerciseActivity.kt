package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityExerciseBinding
import com.example.workoutapp.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {

    private var binding: ActivityExerciseBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var tenSecondTimer = 10

    private var ExerciseTimer: CountDownTimer? = null
    private var ExerciseProgress = 0
    private var thirtySecondTimer = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setupRestView()
    }

    private fun setupRestView() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        setRestProgressBar()
    }

    private fun setupExericaseView() {
        binding?.flProgressBar?.visibility = View.INVISIBLE
        binding?.tvTitle?.text = "Exercise Name"
        binding?.flExerciseView?.visibility = View.VISIBLE

        if (ExerciseTimer != null) {
            ExerciseTimer?.cancel()
            ExerciseProgress = 0
        }
        setExericseProgressBar()

    }

    private fun setRestProgressBar() {
        binding?.progressBar?.progress = restProgress

        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress = tenSecondTimer - restProgress
                binding?.tvTimer?.text = (tenSecondTimer - restProgress).toString()
            }

            override fun onFinish() {
                setupExericaseView()
            }
        }.start()
    }

    private fun setExericseProgressBar() {
        binding?.progressBarExercise?.progress = ExerciseProgress

        ExerciseTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                ExerciseProgress++
                binding?.progressBarExercise?.progress = thirtySecondTimer - ExerciseProgress
                binding?.tvTimerExercise?.text = (thirtySecondTimer - ExerciseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "30 sec is finish, Lets rest!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.start()
    }

    override fun onDestroy() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        super.onDestroy()
        binding = null
    }

}