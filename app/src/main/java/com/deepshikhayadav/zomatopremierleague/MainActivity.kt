package com.deepshikhayadav.zomatopremierleague

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   /* var arrayList = ArrayList<MyModel>()
    val set: MutableSet<String> = HashSet()*/
    lateinit var play:String
    lateinit var p:String
    lateinit var played: TextView
    lateinit var mp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        played=findViewById(R.id.played)
        mp=findViewById(R.id.mp)

        p=award.text.toString()
       /* val bundle=intent.extras
        val awardInt=bundle?.get("prize")
        val won=bundle?.get("result")
        if(awardInt!=null){
            val s=awardInt.toString().toInt()

            val c=s+p.toInt()
            Toast.makeText(this,"" +s+" "+p+" "+c,Toast.LENGTH_SHORT).show()
            award.text = c.toString()
            val sharedPreferences: SharedPreferences = this.getSharedPreferences("sharepref8",
                Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putInt("award",c)
            editor.putInt("won",won.toString().toInt())
            editor.apply()
        }
        if(won!=null){
            win.text=won.toString()
        }*/

   //     var iPlay=play.toInt()

     /*   val sharedPreferences: SharedPreferences = this.getSharedPreferences("sharepref4",
            Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putInt("play",iPlay)
        editor.apply()
*/
       // Toast.makeText(this,p.toString(),Toast.LENGTH_SHORT).show()
        val l1=findViewById<LinearLayout>(R.id.linear)
        l1.setOnClickListener {
            val intent=Intent(this,Coin::class.java)
            getAction.launch(intent)
        }
        val l2=findViewById<LinearLayout>(R.id.linear2)
        l2.setOnClickListener {
           val intent=Intent(this,ManOfTheMatch::class.java)
            getAction.launch(intent)
        }
        val l3=findViewById<LinearLayout>(R.id.linear3)
        l3.setOnClickListener {
            val intent=Intent(this,TeamWinner::class.java)
            getAction.launch(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        play=played.text.toString()
        //p=award.text.toString()

        //Toast.makeText(applicationContext,award.text.toString()+ "Start",Toast.LENGTH_SHORT).show()
    }
    val getAction= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode==Activity.RESULT_OK){
           // val s= it.data!!.extras?.get("result")
            /* var s2=it.data!!.extras?.get("prize")
            val s3=award.text.toString().toInt()
            if(s2!=null) {
                val s4 = s3 + s2.toString().toInt()
                award.text = s4.toString()
            }*/
            //arrayList.add(MyModel(s,""))

           // set.addAll(arrayList)


           // val s2= it.data!!.extras?.get("result2").toString()
            //arrayList.add(s)
             //Toast.makeText(applicationContext,s.toString(),Toast.LENGTH_SHORT).show()
            val b=play.toInt()+1

            play=b.toString()
            played.text=play
            val sharedPreferences: SharedPreferences = this.getSharedPreferences("sharepref4",
                Context.MODE_PRIVATE)
            //val gson = Gson()
            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putInt("play",b)
           // editor.putInt("CoinTeam",s2.toString().toInt())

            editor.apply()

            //Toast.makeText(applicationContext,play,Toast.LENGTH_SHORT).show()
        }

    }
    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("sharepref4", MODE_PRIVATE)
        val mPlay =sharedPreferences.getInt("play",play.toInt())

        val sharedPreferences2 = getSharedPreferences("sharepref8", MODE_PRIVATE)
        val awar =sharedPreferences2.getInt("award",0)
        val won =sharedPreferences2.getInt("won",0)

        findViewById<TextView>(R.id.award).text=awar.toString()
        win.text=won.toString()

        played.text=mPlay.toString()
       // Toast.makeText(applicationContext,mPlay.toString()+ "holla",Toast.LENGTH_SHORT).show()

       p=award.text.toString()
        val p2=win.text.toString()
       // Toast.makeText(applicationContext,p+" resume",Toast.LENGTH_SHORT).show()
        val bundle=intent.extras
        val awardInt=bundle?.get("prize")
        val won2=bundle?.get("result")
        if(awardInt!=null){
            val s=awardInt.toString().toInt()
            val c=s+p.toInt()
            val s2=won2.toString().toInt()
            val c2=s2+p2.toInt()
            win.text=c2.toString()
            //Toast.makeText(this,"" +s+" "+p+" "+c,Toast.LENGTH_SHORT).show()
            award.text = c.toString()
            val sharedPreferences: SharedPreferences = this.getSharedPreferences("sharepref8",
                Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putInt("award",c)
            editor.putInt("won",c2)
            editor.apply()
        }
       /* if(won2!=null){

        }*/
    }

}