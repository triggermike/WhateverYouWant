package com.hugheswd.whateveryouwant

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
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
        countDown(etMainUserInput.text.toString().toLong())
    }

    private fun countDown(num: Long) {
        val timer = TheTimer(num * 1000, 1000 , mainText)
        timer.start()
    }

    private class TheTimer(interval: Long,
                           endTime: Long,
                           val textView: TextView
    ):CountDownTimer(interval, endTime) {
        override fun onFinish() {
            textView.text = "DONE!!!!!!!"
        }

        override fun onTick(millisUntilFinished: Long) {
            val timeLeft = millisUntilFinished / 1000
            textView.text = timeLeft.toString()
        }
    }
}