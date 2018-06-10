package com.hugheswd.whateveryouwant

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.TextView

class TheTimer(interval: Long,
               endTime: Long,
               val textView: TextView,
               val context: Context)
    : CountDownTimer(interval, endTime) {

    override fun onFinish() {
        callAlarm()
        textView.text = context.getText(R.string.done)
    }

    private fun callAlarm() {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibeTime: Long = 3000
        MediaPlayer.create(context, R.raw.horn).start()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(vibeTime, VibrationEffect.DEFAULT_AMPLITUDE))
        } else vibrator.vibrate(vibeTime)
    }

    override fun onTick(millisUntilFinished: Long) {
        val timeLeft = millisUntilFinished / 1000
        val displayTime = timeLeft + 1
        if (millisUntilFinished < 2000) {
            textView.text = context.getString(R.string.almost_done)
        } else {
            textView.text = displayTime.toString()
        }
    }
}