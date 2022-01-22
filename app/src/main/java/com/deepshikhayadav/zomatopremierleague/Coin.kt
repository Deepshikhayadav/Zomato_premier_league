package com.deepshikhayadav.zomatopremierleague

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_coin.*
import java.util.*


class Coin : AppCompatActivity() {
    private val handler = Handler()
    val returnIntent = Intent()
    val del="Delhi Capitals"
    val sun="Sunrisers"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)
        val time1=findViewById<TextView>(R.id.time1)
        val time2=findViewById<TextView>(R.id.time2)
        val btn1=findViewById<Button>(R.id.btn1)
        val btn2=findViewById<Button>(R.id.btn2)
        val btn3=findViewById<Button>(R.id.btn3)
        val btn4=findViewById<Button>(R.id.btn4)
        val teamName =findViewById<TextView>(R.id.teamName)
        val win =findViewById<TextView>(R.id.win)
        val teamName2=findViewById<TextView>(R.id.teamName2)
        val win2=findViewById<TextView>(R.id.win2)

        btn1.setOnClickListener {
            btn1.isEnabled=false
            btn2.isEnabled=false

            showLinear(sun)
            val sharedPreferences = getSharedPreferences("sharepref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable",false)
          /*  val returnIntent = Intent()
            returnIntent.putExtra("result","Sunriser");*/
            editor.apply()
            setResult(Activity.RESULT_OK/*,returnIntent*/)
            finish()
        }
        btn2.setOnClickListener {
            btn1.isEnabled=false
            btn2.isEnabled=false
            showLinear("Rajsathan Royals")
            val sharedPreferences = getSharedPreferences("sharepref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable",false)
            /*val returnIntent = Intent()
            returnIntent.putExtra("result","Rajasthan Royals");*/
            editor.apply()
            setResult(Activity.RESULT_OK/*,returnIntent*/)
            finish()
        }
        btn3.setOnClickListener {
            btn3.isEnabled=false
            btn4.isEnabled=false
            showLinear2("Knight Riders")
            val sharedPreferences = getSharedPreferences("sharepref2", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable2",false)
           /* val returnIntent = Intent()
            returnIntent.putExtra("result","Knight riders");*/
            editor.apply()
            setResult(Activity.RESULT_OK/*,returnIntent*/)
            finish()
        }
        btn4.setOnClickListener {
            btn3.isEnabled=false
            btn4.isEnabled=false
            showLinear2(del)
            val sharedPreferences = getSharedPreferences("sharepref2", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("enable2",false)
            editor.apply()
            setResult(Activity.RESULT_OK/*,returnIntent*/)
            finish()
        }

        handler.post(object : Runnable {
            override fun run() {
                // Keep the postDelayed before the updateTime(), so when the event ends, the handler will stop too.
                handler.postDelayed(this, 1000)
                updateTime(time1,btn1,btn2)
                updateTime2(time2,btn3,btn4)
            }
        })

    }

    private fun showLinear( str: String) {
       // teamWinner?.visibility= View.VISIBLE
        teamName.text=str
        val sharedPreferences = getSharedPreferences("sharepref6", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("enable6",str)
        editor.apply()
    }
    private fun showLinear2( str: String) {
       // teamWinner?.visibility= View.VISIBLE
        teamName2.text=str
        val sharedPreferences = getSharedPreferences("sharepref7", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("enable7",str)
        editor.apply()
    }

    private fun updateTime2(time2: TextView?,btn3:Button,btn4:Button) {

        val currentDate = Calendar.getInstance()
        val eventDate2 = Calendar.getInstance()
        eventDate2[Calendar.YEAR] = 2022
        eventDate2[Calendar.MONTH] = 0 // 0-11 so 1 less
        eventDate2[Calendar.DAY_OF_MONTH] = 17
        eventDate2[Calendar.HOUR] = 7
        eventDate2[Calendar.MINUTE] = 36
        eventDate2[Calendar.SECOND] = 0
        eventDate2.timeZone = TimeZone.getTimeZone("GMT")

        val diff2 = eventDate2.timeInMillis - currentDate.timeInMillis
        val days = diff2 / (24 * 60 * 60 * 1000)
        val hours = diff2 / (1000 * 60 * 60) % 24
        val minutes = diff2 / (1000 * 60) % 60
        val seconds = (diff2 / 1000) % 60
        time2?.post{
            if(days>=0 && hours>=0 && minutes>=0 && seconds>=0) {
                time2.text= "${days}D ${hours}H ${minutes}M ${seconds}S"
            }
            else{
                time2.text= "Your time has been expired"
                if(teamName2.text==del){
                    win2.text="You Won"
                    val ret = Intent(this,MainActivity::class.java)
                    win2.setOnClickListener {
                       // Toast.makeText(applicationContext,"nvhsbjv",Toast.LENGTH_SHORT).show()
                        prize2.visibility=View.VISIBLE
                        prize2.setOnClickListener {
                            ret.putExtra("prize", 20)
                            ret.putExtra("result",1)
                            startActivity(ret)
                        }
                    }

                    win2.setTextColor(Color.parseColor("#1ACF15"))
                }
                else
                {
                    win2.text="You Lost"
                    win2.setTextColor(Color.parseColor("#D31212"))
                    returnIntent.putExtra("result2",1);
                }
                btn3.isEnabled=false
                btn4.isEnabled=false
            }
        }
    }

    private fun updateTime(time :TextView,btn1:Button,btn2:Button) {

        val currentDate = Calendar.getInstance()
        // Set Event Date
        val eventDate = Calendar.getInstance()
        eventDate[Calendar.YEAR] = 2022
        eventDate[Calendar.MONTH] = 0 // 0-11 so 1 less
        eventDate[Calendar.DAY_OF_MONTH] = 17
        eventDate[Calendar.HOUR] = 5
        eventDate[Calendar.MINUTE] = 0
        eventDate[Calendar.SECOND] = 0
        eventDate.timeZone = TimeZone.getTimeZone("GMT")

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
               if(teamName.text==sun){
                   win.text="You Won"
                   val ret = Intent(this,MainActivity::class.java)
                   win.setOnClickListener {
                       // Toast.makeText(applicationContext,"nvhsbjv",Toast.LENGTH_SHORT).show()
                       prize.visibility = View.VISIBLE
                       prize.setOnClickListener {
                           ret.putExtra("prize", 20)
                           ret.putExtra("result",1)
                           startActivity(ret)

                       }
                   }
                   win.setTextColor(Color.parseColor("#1ACF15"))

               }
               else
               {
                   win.text="You Lost"
                   win.setTextColor(Color.parseColor("#D31212"))
                   returnIntent.putExtra("result2",1);
               }
               btn1.isEnabled=false
               btn2.isEnabled=false
           }
       }
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("sharepref", MODE_PRIVATE)
        val bool =sharedPreferences.getBoolean("enable",true)
        val sharedPreferences2 = getSharedPreferences("sharepref2", MODE_PRIVATE)
        val bool2 =sharedPreferences2.getBoolean("enable2",true)
        val sharedPreferences3 = getSharedPreferences("sharepref6", MODE_PRIVATE)
        val str =sharedPreferences3.getString("enable6","Your Selection")
        val sharedPreferences4 = getSharedPreferences("sharepref7", MODE_PRIVATE)
        val str2 =sharedPreferences4.getString("enable7","Your Selection")
        teamName.text=str
        teamName2.text=str2
        findViewById<Button>(R.id.btn1).isEnabled=bool
        findViewById<Button>(R.id.btn2).isEnabled=bool

        findViewById<Button>(R.id.btn3).isEnabled=bool2
        findViewById<Button>(R.id.btn4).isEnabled=bool2
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_OK,returnIntent)
        finish()
    }
}