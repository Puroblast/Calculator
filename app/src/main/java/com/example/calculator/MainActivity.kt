package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.math.min

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

        binding.oneButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("1")
            if (lastFunction == ""){
                renew()
            }

        }
        binding.twoButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("2")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.threeButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("3")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.fourButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("4")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.fiveButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("5")
            if (lastFunction == ""){
                renew()
            }

        }
        binding.sixButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("6")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.sevenButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("7")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.eightButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("8")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.nineButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("9")
            if (lastFunction == ""){
                renew()
            }


        }
        binding.zeroButton.setOnClickListener {
            if (equalpressed) {
                binding.totalView.text = ""
                equalpressed = false
            }
            if(lastFunction != ""){
                binding.totalView.text = ""
            }
            binding.totalView.append("0")
            if (lastFunction == ""){
                renew()
            }

        }
        binding.multButton.setOnClickListener {
            if (lastFunction == "divide" || lastFunction == "multiply") {
                equal()
            } else if (lastFunction == "plus" || lastFunction == "minus") {
                renew()
            }
            lastFunction = "multiply"
        }
        binding.minusButton.setOnClickListener {
            firstNumber = binding.totalView.text.toString().toInt()
            firstFunction = "minus"
            if (lastFunction != "") {
                firstFunction = ""
                equal()
                lastFunction = "minus"
            }
            lastFunction = "minus"
        }
        binding.slashButton.setOnClickListener {
            if (lastFunction == "divide" || lastFunction == "multiply") {
                equal()
            } else if (lastFunction == "plus" || lastFunction == "minus") {
                renew()
            }
            lastFunction = "divide"
        }
        binding.plusButton.setOnClickListener {
            firstNumber = binding.totalView.text.toString().toInt()
            firstFunction = "plus"
            if (lastFunction != "") {
                firstFunction = ""
                equal()
                lastFunction = "plus"
            }
            lastFunction = "plus"
        }
        binding.equalButton.setOnClickListener {
            equal()
        }
        binding.clearButton.setOnClickListener {
            binding.totalView.text = ""
            equalpressed = false
            lastFunction = ""
            firstFunction = ""
            firstNumber = 0
        }
    }

    private fun equal() {
        equalpressed = true
        when(lastFunction) {

            "multiply" -> {
                multiply()
                binding.totalView.text = memory.toString()
                lastFunction = ""
            }
            "divide" -> {
                divide()
                binding.totalView.text = memory.toString()
                lastFunction = ""
            }
            "plus" -> {
                plus()
                binding.totalView.text = memory.toString()
                lastFunction = ""
                firstFunction = ""
            }
            "minus" -> {
                minus()
                binding.totalView.text = memory.toString()
                lastFunction = ""
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
        renew()
    }

    private fun renew() {
        if (binding.totalView.text != "") {
            memory = binding.totalView.text.toString().toInt()
        }

    }

    private fun multiply() {
        if (equalpressed) {
            memory = memory * binding.totalView.text.toString().toInt()
        } else {
            equal()
        }

    }

    private fun divide() {
        if (equalpressed) {
            memory = memory / binding.totalView.text.toString().toInt()
        } else {
            equal()
        }
    }

    private fun plus() {
        if (equalpressed) {
            memory = memory + binding.totalView.text.toString().toInt()
        } else {
            equal()
        }
    }

    private fun minus() {
        if (equalpressed) {
            memory = memory - binding.totalView.text.toString().toInt()
        } else {
            equal()
        }
    }

}