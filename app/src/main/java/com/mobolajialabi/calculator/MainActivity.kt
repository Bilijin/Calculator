package com.mobolajialabi.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobolajialabi.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var curValue : Double = 0.0
    private var calculated = 0
    private var curOperators = arrayListOf<Int>()

    // + == 1
    // - == 2
    // * == 3
    // / == 4
    // = == 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.one.setOnClickListener { showNumber(1) }
        binding.two.setOnClickListener { showNumber(2) }
        binding.three.setOnClickListener { showNumber(3) }
        binding.four.setOnClickListener { showNumber(4) }
        binding.five.setOnClickListener {  showNumber(5) }
        binding.six.setOnClickListener { showNumber(6) }
        binding.seven.setOnClickListener { showNumber(7) }
        binding.eight.setOnClickListener { showNumber(8) }
        binding.nine.setOnClickListener { showNumber(9) }
        binding.zero.setOnClickListener { showNumber(0) }
        binding.plus.setOnClickListener { showOperator("+") }
        binding.minus.setOnClickListener { showOperator("-") }
        binding.divide.setOnClickListener { showOperator("/") }
        binding.multiply.setOnClickListener { showOperator("*") }
        binding.equals.setOnClickListener { calculate()}
        binding.erase.setOnClickListener { erase(binding.screen.text.toString()) }
    }

    private fun add(val1: Double, val2: Double) : Double {
        return val1 + val2
    }
    
    private fun subtract(val1 :  Double, val2 :  Double) :  Double {
        return val1 - val2
    }
    
    private fun multiply(val1 :  Double, val2 :  Double) :  Double {
        return val1 * val2
    }
    
    private fun divide(val1 :  Double, val2 :  Double) :  Double {
        return val1 / val2
    }
    
    private fun calculate() {
        calculated = 1

        val x = binding.screen.text.toString().split('+', '-', '*', '/')
        curValue = x[0].toDouble()

        for ((count, _) in (0 until x.lastIndex).withIndex()) {
            curValue = when (curOperators[count]) {
                1 -> add(curValue, x[count + 1].toDouble())
                2 -> subtract(curValue, x[count + 1].toDouble())
                3 -> multiply(curValue, x[count + 1].toDouble())
                4 -> divide(curValue, x[count + 1].toDouble())

                else -> 0.0
            }
        }

        binding.screen.text = ""
        binding.screen.text = curValue.toString()
        curOperators.clear()
    }
    
    private fun showOperator(op : String)  {
        val v = binding.screen.text.toString()

        if (!v.endsWith('/') && !v.endsWith('*') && !v.endsWith('+')  && !v.endsWith('-') ) {
            binding.screen.text = getString(R.string.value2, binding.screen.text, op)

            curOperators.add(when (op) {
                "+" -> 1
                "-" -> 2
                "*" -> 3
                "/" -> 4
                else -> 0
            })
        }

    }
    
    private fun showNumber(no : Int) {
        if (calculated != 0) {
            binding.screen.text = ""
            calculated = 0
        }

        if (binding.screen.text != "0") {
            binding.screen.text = getString(R.string.value, binding.screen.text, no)
        } else {
           binding.screen.text = no.toString()
        }
    }

    private fun erase(str : String){
        val x = str.dropLast(1)
        binding.screen.text = x
    }
}