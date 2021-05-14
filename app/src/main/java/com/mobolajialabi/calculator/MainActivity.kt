package com.mobolajialabi.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobolajialabi.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var curValue = 1
    private var dupValue = 1
    private var bb = arrayListOf<Int>()
    private var curOperator = 0

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
        binding.plus.setOnClickListener {
            showOperator("+")
        }
        binding.minus.setOnClickListener { showOperator("-") }
        binding.divide.setOnClickListener { showOperator("/") }
        binding.multiply.setOnClickListener { showOperator("*") }
        binding.equals.setOnClickListener { calculate() }
    }

    private fun add() {
        curValue = binding.screen.text.toString().toInt()

        binding.screen.text = ""

//        binding.screen.text = getString(R.string.value2, binding.screen.text, "+")
    }

    private fun showNumber(no : Int) {
        binding.screen.text = getString(R.string.value, binding.screen.text, no)
    }

    private fun showOperator(va : String) {
        curValue = binding.screen.text.toString().toInt()

//        binding.screen.text = getString(R.string.value2, binding.screen.text, va)

        if (curOperator != 0)  {
            when (curOperator) {
                1 -> curValue += binding.screen.text.toString().toInt()
                2 -> curValue -= binding.screen.text.toString().toInt()
                3 -> curValue *= binding.screen.text.toString().toInt()
                4 -> curValue /= binding.screen.text.toString().toInt()
            }
        }
    }

    private fun calculate() {
        val vv = binding.screen.text
        val list = vv.split('/', '*', '+', '-')

//        for (char in vv) {
//            if (char.toInt() in=)
//            if (char == '/') {
//                for (c in )
//            }
//        }

//        binding.screen.text = list.toString()

        var v : Int

//        if (vv.contains('*')) {
//            val list = vv.split('*')
//
//            if (!vv.contains('/') && !vv.contains('+') && !vv.contains('-')) {
//                for (element in list) {
////                    v = curValue
//
//                    curValue *= element.toInt()
//                }
//
//                binding.screen.text = curValue.toString()
//            }
//        }
    }
}