package com.hugheswd.whateveryouwant

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainText.text = countDown(50)
        countDownToo(50)
    }

    private fun countDown(num: Int): String {
        var ber = num
        var numberString = ""

        while (ber > 0) {
            numberString += "$ber \n"
            ber--
        }
        return numberString
    }
    private fun countDownToo(num: Int) = arrayListOf(num downTo 0).toString()

}
