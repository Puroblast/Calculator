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
            if (lastFunction != "") {
                equal()
            }
            lastFunction = "multiply"
        }
        binding.minusButton.setOnClickListener {
            if (lastFunction != "") {
                equal()
            }
            lastFunction = "minus"
        }
        binding.slashButton.setOnClickListener {
            if (lastFunction != "") {
                equal()
            }
            lastFunction = "divide"
        }
        binding.plusButton.setOnClickListener {
            if (lastFunction != "") {
                equal()
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
        }
    }

    private fun equal() {
        equalpressed = true
        when(lastFunction) {

            "multiply" -> {
                multiply()
                binding.totalView.text = memory.toString()
                lastFunction = ""
                renew()
            }
            "divide" -> {
                divide()
                binding.totalView.text = memory.toString()
                lastFunction = ""
                renew()
            }
            "plus" -> {
                plus()
                binding.totalView.text = memory.toString()
                lastFunction = ""
                renew()
            }
            "minus" -> {
                minus()
                binding.totalView.text = memory.toString()
                lastFunction = ""
                renew()
            }

        }
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