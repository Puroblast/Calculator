package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private var memory: Int = 0
    private var firstNumber = 0
    private var lastFunction = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.oneButton.setOnClickListener {
            binding.totalView.append("1")
            renew()

        }
        binding.twoButton.setOnClickListener {
            binding.totalView.append("2")
            if (lastFunction == "") {
                renew()
            }


        }
        binding.threeButton.setOnClickListener {
            binding.totalView.append("3")
            renew()


        }
        binding.fourButton.setOnClickListener {
            binding.totalView.append("4")
            renew()


        }
        binding.fiveButton.setOnClickListener {
            binding.totalView.append("5")
            if(lastFunction == "") {
                renew()
            }

        }
        binding.sixButton.setOnClickListener {
            binding.totalView.append("6")
            renew()


        }
        binding.sevenButton.setOnClickListener {
            binding.totalView.append("7")
            renew()


        }
        binding.eightButton.setOnClickListener {
            binding.totalView.append("8")
            renew()


        }
        binding.nineButton.setOnClickListener {
            binding.totalView.append("9")
            renew()


        }
        binding.zeroButton.setOnClickListener {
            binding.totalView.append("0")
            renew()

        }
        binding.multButton.setOnClickListener {
            renew()
            lastFunction = "multiply"
            binding.totalView.text = "0"
        }
        binding.minusButton.setOnClickListener {
            renew()
            binding.totalView.text = "0"
        }
        binding.slashButton.setOnClickListener {
            renew()
            binding.totalView.text = "0"
        }
        binding.plusButton.setOnClickListener {
            renew()
            binding.totalView.text = "0"
        }
        binding.equalButton.setOnClickListener {
            equal()
        }
        binding.clearButton.setOnClickListener {
            binding.totalView.text = "0"
        }
    }

    private fun equal() {
        when(lastFunction) {

            "multiply" -> binding.totalView.text = multiply().toString()
            "divide" -> divide()
            "plus" -> plus()
            "minus" -> minus()

        }
    }

    private fun renew() {
        memory = binding.totalView.text.toString().toInt()
    }

    private fun multiply() : Int {
        memory = memory * binding.totalView.text.toString().toInt()
        return memory
    }

    private fun divide() {
        null
    }

    private fun plus() {
        null
    }

    private fun minus() {
        null
    }

}