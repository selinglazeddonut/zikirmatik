package com.example.zikircounter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.zikircounter.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private var numberTextView = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        loadData()

        binding.btnPlus.setOnClickListener {
            numberTextView++
            binding.numberTextView.text = numberTextView.toString()
            saveData()
        }

        binding.btnReset.setOnClickListener {
            numberTextView = 0
            binding.numberTextView.text = numberTextView.toString()
            saveData()
        }
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("numberTextView", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(" ", numberTextView)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("numberTextView", Context.MODE_PRIVATE)
        numberTextView = sharedPreferences.getInt(" ", 0)
        binding.numberTextView.text = numberTextView.toString()



    }
}
