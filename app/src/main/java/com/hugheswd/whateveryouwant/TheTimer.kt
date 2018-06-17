package com.hugheswd.whateveryouwant

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator


class TheTimer(interval: Long,
               endTime: Long,
               val mainActivity: MainActivity)
    : CountDownTimer(interval, endTime) {

    override fun onFinish() {
        val timerAlert = AlertList.getRandomAlert()
        callAlarm(timerAlert.audioRes)
        mainActivity.setMainText(mainActivity.getString(timerAlert.alertString))
        mainActivity.clearTimerInputText()
    }

    private fun callAlarm(audioRes: Int) {
        val vibrator = mainActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibeTime: Long = 3000
        MediaPlayer.create(mainActivity, audioRes).start()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(vibeTime, VibrationEffect.DEFAULT_AMPLITUDE))
        } else vibrator.vibrate(vibeTime)
    }

    override fun onTick(millisUntilFinished: Long) {
        val timeLeft = millisUntilFinished / 1000
        val displayTime = timeLeft + 1
        if (millisUntilFinished < 2000) {
            mainActivity.setMainText(mainActivity.getString(R.string.almost_done))
        } else {
            mainActivity.setMainText(displayTime.toString())
        }
    }

}