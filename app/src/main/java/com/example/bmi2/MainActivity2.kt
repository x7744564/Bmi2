package com.example.bmi2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    //全域變數, lateinit -> 晚點一定會產生物件的連結
    private lateinit var binding :ActivityMainBinding
    val secret = (1..10).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        //val binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this,"$secret", Toast.LENGTH_LONG).show()
    }


    fun guess(view: View) {
        //正常從資源取得字串的寫法
        //resources.getString(R.string.smaller)

        //println("Clicked")
        if(!binding.number.text.toString().equals("")) {
            //取得物件的資料
            //透過 binding 取得layout上的資料
            val num = binding.number.text.toString().toInt()
            //log debug
            Log.d("MainActivity2", num.toString())

            val message = if(num>secret){
                getString(R.string.smaller)
            } else if (num < secret) {
                getString(R.string.bigger)
            } else {
                getString(R.string.you_got_it)
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok),null)
                .show()
        } else {
            //不重要的訊息可以使用Toast(浮動訊息)提醒User
            Toast.makeText(this,getString(R.string.please_enter_number_1_10), Toast.LENGTH_LONG).show()
        }
    }

}