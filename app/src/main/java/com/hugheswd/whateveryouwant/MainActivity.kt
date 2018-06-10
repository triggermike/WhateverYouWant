package com.hugheswd.whateveryouwant

import android.os.*
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainUserInput.setOnClickListener {
            timerStart()
        }

        etMainUserInput.setOnKeyListener { v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN){
                timerStart()
                true
            }
            false
        }
    }

    private fun timerStart() {
        val input = etMainUserInput.text.toString()
        if (!input.isBlank()) {
            val num = input.toLong()
            if (num != 0L) {
                countDown(num)
            } else {
                mainText.text = getString(R.string.no_time)
            }
        } else {
            mainText.text = getString(R.string.no_time)
        }
    }

    private fun countDown(num: Long) {
        val timer = TheTimer(num * 1000, 1000 , mainText, this)
        timer.start()
    }
}