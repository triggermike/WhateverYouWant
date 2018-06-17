package com.hugheswd.whateveryouwant

import android.content.Context
import java.util.*

class TimerAlert (val alertString: Int, val audioRes: Int)

object AlertList {
    val things = arrayListOf(
            TimerAlert(R.string.alert_alarm_clock, R.raw.alarm_clock),
            TimerAlert(R.string.alert_alien, R.raw.alien),
            TimerAlert(R.string.alert_busted, R.raw.busted),
            TimerAlert(R.string.alert_coffees_done, R.raw.coffees_done),
            TimerAlert(R.string.alert_crashburn, R.raw.crashburn),
            TimerAlert(R.string.alert_dinner, R.raw.dinner),
            TimerAlert(R.string.alert_horn, R.raw.horn),
            TimerAlert(R.string.alert_industrial, R.raw.industrial),
            TimerAlert(R.string.alert_macpan, R.raw.macpan),
            TimerAlert(R.string.alert_ooga, R.raw.ooga),
            TimerAlert(R.string.alert_pewpew, R.raw.pewpew),
            TimerAlert(R.string.alert_squeep, R.raw.squeep),
            TimerAlert(R.string.alert_super_storm, R.raw.super_storm)
    )

    fun getRandomAlert(): TimerAlert {
        return things[Random().nextInt(things.size)]
    }
}