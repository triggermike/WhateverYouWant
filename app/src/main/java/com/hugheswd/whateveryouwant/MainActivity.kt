package com.hugheswd.whateveryouwant

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainUserInput.setOnClickListener {
            timerStart()
        }

        etMainUserInput.setOnKeyListener { v, keyCode, event ->
            if(keyCode == EditorInfo.IME_NULL && event.action == KeyEvent.ACTION_UP){
                timerStart()
                true
            }
            false
        }

    }

    private fun timerStart() {
        var theString = ""

        AsyncTask.execute {
            theString = countDown(etMainUserInput.text.toString().toInt())

            runOnUiThread {
                mainText.text = theString
            }
        }

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
