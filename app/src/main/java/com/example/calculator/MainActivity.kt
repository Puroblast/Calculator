package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private var memory = 0
    private var lastFunction = ""
    private var equalpressed = false
    private var firstNumber = 0
    private var firstFunction = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.oneButton.setOnClickListener { btnPressed("1") }
        binding.twoButton.setOnClickListener { btnPressed("2") }
        binding.threeButton.setOnClickListener { btnPressed("3") }
        binding.fourButton.setOnClickListener { btnPressed("4") }
        binding.fiveButton.setOnClickListener { btnPressed("5") }
        binding.sixButton.setOnClickListener { btnPressed("6") }
        binding.sevenButton.setOnClickListener { btnPressed("7") }
        binding.eightButton.setOnClickListener { btnPressed("8") }
        binding.nineButton.setOnClickListener { btnPressed("9") }
        binding.zeroButton.setOnClickListener { btnPressed("0") }

        binding.multButton.setOnClickListener { setOrder("multiply") }
        binding.minusButton.setOnClickListener { setOrder("minus") }
        binding.slashButton.setOnClickListener { setOrder("divide") }
        binding.plusButton.setOnClickListener { setOrder("plus") }

        binding.equalButton.setOnClickListener { equal() }

        binding.clearButton.setOnClickListener { clear() }
    }

    private fun btnPressed(btnNumber: String) {
        if (equalpressed) {
            binding.totalView.text = ""
            equalpressed = false
        }
        if (lastFunction != "") {
            binding.totalView.text = ""
        }

        binding.totalView.append(btnNumber)

        if (lastFunction == "" && binding.totalView.text != "") {
            memory = binding.totalView.text.toString().toInt()
        }
    }

    private fun setOrder(btn: String) {
        if (listOf("minus", "plus").contains(btn)) {
            firstNumber = binding.totalView.text.toString().toInt()
            firstFunction = btn
            if (lastFunction != "") {
                firstFunction = ""
                equal()
                lastFunction = btn
            }

            lastFunction = btn

        } else {
            if (listOf("divide", "multiply").contains(lastFunction)) {
                equal()
            } else if (listOf("plus", "minus").contains(lastFunction)) {
                memory = binding.totalView.text.toString().toInt()
            }

            lastFunction = btn
        }
    }

    private fun clear() {
        binding.totalView.text = ""
        equalpressed = false
        lastFunction = ""
        firstFunction = ""
        firstNumber = 0
    }

    private fun calculation(operation: String) {
        if (equalpressed) {
            when (operation) {
                "plus" -> memory += binding.totalView.text.toString().toInt()
                "minus" -> memory -= binding.totalView.text.toString().toInt()
                "divide" -> memory /= binding.totalView.text.toString().toInt()
                "multiply" -> memory *= binding.totalView.text.toString().toInt()
            }
        } else {
            equal()
        }

        binding.totalView.text = memory.toString()
        lastFunction = ""
    }


    private fun equal() {
        equalpressed = true

        when (lastFunction) {
            "multiply" -> {
                calculation("multiply")
            }
            "divide" -> {
                calculation("divide")
            }
            "plus" -> {
                calculation("plus")
                firstFunction = ""
            }
            "minus" -> {
                calculation("minus")
                firstFunction = ""
            }
        }

        if (firstFunction == "plus") {
            memory += firstNumber
            firstFunction = ""
        } else if (firstFunction == "minus") {
            memory -= firstNumber
            firstFunction = ""
        }

        binding.totalView.text = memory.toString()
    }
}