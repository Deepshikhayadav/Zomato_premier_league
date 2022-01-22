package com.deepshikhayadav.zomatopremierleague

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import java.util.*

class ManOfTheMatch : AppCompatActivity() {
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_of_the_match)

        val time1=findViewById<TextView>(R.id.time)
        val btn1=findViewById<Button>(R.id.btn1)
        val btn2=findViewById<Button>(R.id.btn2)
        val btn3=findViewById<Button>(R.id.btn3)
        val btn4=findViewById<Button>(R.id.btn4)

        btn1.setOnClickListener {
            btn1.isEnabled=false
            btn2.isEnabled=false
            btn3.isEnabled=false
            btn4.isEnabled=false
            val sharedPreferences = getSharedPreferences("sharepref3", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable3",false)
            editor.apply()
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn2.setOnClickListener {
            btn1.isEnabled=false
            btn2.isEnabled=false
            btn3.isEnabled=false
            btn4.isEnabled=false
            val sharedPreferences = getSharedPreferences("sharepref3", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable3",false)
            editor.apply()
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn3.setOnClickListener {
            btn1.isEnabled=false
            btn2.isEnabled=false
            btn3.isEnabled=false
            btn4.isEnabled=false

            val sharedPreferences = getSharedPreferences("sharepref3", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable3",false)
            editor.apply()
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn4.setOnClickListener {
            btn1.isEnabled=false
            btn2.isEnabled=false
            btn3.isEnabled=false
            btn4.isEnabled=false

            val sharedPreferences = getSharedPreferences("sharepref3", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable3",false)
            editor.apply()
            setResult(Activity.RESULT_OK)
            finish()
        }


        handler.post(object : Runnable {
            override fun run() {
                // Keep the postDelayed before the updateTime(), so when the event ends, the handler will stop too.
                handler.postDelayed(this, 1000)
                updateTime(time1,btn1,btn2,btn3,btn4)
            }
        })

    }
    private fun updateTime(time : TextView,btn1:Button,btn2:Button,btn3:Button,btn4:Button) {

        val currentDate = Calendar.getInstance()
        // Set Event Date
        val eventDate = Calendar.getInstance()
        eventDate[Calendar.YEAR] = 2022
        eventDate[Calendar.MONTH] = 0 // 0-11 so 1 less
        eventDate[Calendar.DAY_OF_MONTH] = 19
        eventDate[Calendar.HOUR] = 8
        eventDate[Calendar.MINUTE] = 28
        eventDate[Calendar.SECOND] = 0
        eventDate.timeZone = TimeZone.getTimeZone("GMT+5:30")

        val diff = eventDate.timeInMillis - currentDate.timeInMillis
        val days = diff / (24 * 60 * 60 * 1000)
        val hours = diff / (1000 * 60 * 60) % 24
        val minutes = diff / (1000 * 60) % 60
        val seconds = (diff / 1000) % 60

        time.post{
            if(days>=0 && hours>=0 && minutes>=0 && seconds>=0) {
                time.text= "${days}D ${hours}H ${minutes}M ${seconds}S"
            }
            else{
                time.text= "Your time has been expired"
                btn1.isEnabled=false
                btn2.isEnabled=false
                btn3.isEnabled=false
                btn4.isEnabled=false
            }
        }

    }
    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("sharepref3", MODE_PRIVATE)
        val bool =sharedPreferences.getBoolean("enable3",true)

        findViewById<Button>(R.id.btn1).isEnabled=bool
        findViewById<Button>(R.id.btn2).isEnabled=bool

        findViewById<Button>(R.id.btn3).isEnabled=bool
        findViewById<Button>(R.id.btn4).isEnabled=bool
    }
}