package com.hugheswd.outtatime

import android.content.Intent
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val endTime = 1000L
    private var timer = TheTimer(endTime, endTime, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(R.drawable.bckgrnd).into(ivMainBackground)

        btnMainUserInput.setOnClickListener {
            timerStart()
        }

        btnMainStop.setOnClickListener {
            timerStop()
        }

        btnSettings.setOnClickListener {
            launchMenu()
        }

        etMainUserInput.setOnKeyListener {v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN){
                timerStart()
            }
            false
        }
    }

    fun setMainText(text: String) {
        mainText.text = text
    }

    fun clearTimerInputText() {
        etMainUserInput.text.clear()
    }

    private fun timerStart() {
        val input = etMainUserInput.text.toString()
        if (!input.isBlank()) {
            val num = input.toLong()
            if (num != 0L) {
                timer.cancel()
                timer = TheTimer(num * 1000, endTime, this)
                countDown()
                clearTimerInputText()
            } else {
                setMainText(getString(R.string.no_time))
                clearTimerInputText()
            }
        } else {
            setMainText(getString(R.string.no_time))
            clearTimerInputText()
        }
    }

    private fun timerStop() {
        timer.cancel()
        setMainText(getString(R.string.stop))
        etMainUserInput.text.clear()
        clearTimerInputText()
    }

    private fun countDown() {
        timer.start()
    }

    private fun launchMenu() = startActivity(Intent(this, SettingsActivity::class.java))

}