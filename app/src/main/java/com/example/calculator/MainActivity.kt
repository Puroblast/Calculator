package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.oneButton.setOnClickListener {binding.totalView.append("1")}
        binding.twoButton.setOnClickListener {binding.totalView.append("2")}
        binding.threeButton.setOnClickListener {binding.totalView.append("3")}
        binding.fourButton.setOnClickListener {binding.totalView.append("4")}
        binding.fiveButton.setOnClickListener {binding.totalView.append("5")}
        binding.sixButton.setOnClickListener {binding.totalView.append("6")}
        binding.sevenButton.setOnClickListener {binding.totalView.append("7")}
        binding.eightButton.setOnClickListener {binding.totalView.append("8")}
        binding.nineButton.setOnClickListener {binding.totalView.append("9")}
        binding.zeroButton.setOnClickListener {binding.totalView.append("0")}
        binding.multButton.setOnClickListener {binding.totalView.append(" * ")}
        binding.minusButton.setOnClickListener {binding.totalView.append(" - ")}
        binding.slashButton.setOnClickListener {binding.totalView.append(" / ")}
        binding.plusButton.setOnClickListener {binding.totalView.append(" + ")}
        binding.equalButton.setOnClickListener { equal(binding.totalView.text.toString()) }
        binding.clearButton.setOnClickListener { binding.totalView.text = ""}
    }

    private fun equal(text:String) {
        println(text)
    }


}