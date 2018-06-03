package com.hugheswd.whateveryouwant

import android.content.Context
import android.media.MediaPlayer
import android.os.*
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
        val timer = TheTimer(num * 1000, 1000 , mainText, this)
        timer.start()
    }

    private class TheTimer(interval: Long,
                           endTime: Long,
                           val textView: TextView,
                           val context: Context)
        :CountDownTimer(interval, endTime) {

        override fun onFinish() {
            callAlarm()
            textView.text = context.getText(R.string.done)
        }

        private fun callAlarm() {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val vibeTime: Long = 5000
            MediaPlayer.create(context, R.raw.horn).start()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(vibeTime, VibrationEffect.DEFAULT_AMPLITUDE))
            } else vibrator.vibrate(vibeTime)
        }

        override fun onTick(millisUntilFinished: Long) {
            val timeLeft = millisUntilFinished / 1000
            textView.text = timeLeft.toString()
        }
    }
}