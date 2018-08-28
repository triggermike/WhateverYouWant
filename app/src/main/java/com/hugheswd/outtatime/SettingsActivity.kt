package com.hugheswd.outtatime

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import java.util.*
import kotlinx.android.synthetic.main.activity_settings.*

/* Implementation of text view for settings menu
 */

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val arrayAdapter = ArrayAdapter<String>(
                this,
                R.layout.list_view_settings,
                ArrayList<String>(Arrays.asList(*resources.getStringArray(R.array.settings_options))))

        lvSettingsMain.adapter = arrayAdapter

    }

}

