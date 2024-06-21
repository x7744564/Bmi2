package com.example.bmi2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi2.databinding.ActivityNicknameBinding

class NicknameActivity : AppCompatActivity() {
    private lateinit var binging: ActivityNicknameBinding
    val TAG = NicknameActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        //Execute
        super.onCreate(savedInstanceState)

        binging = ActivityNicknameBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        //Display screen
        //setContentView(R.layout.activity_nickname)
        setContentView(binging.root)

        //Retrieve data
        //取數字，如取不到資料預設0
        val level = intent.getIntExtra("EXTRA_LEVEL",0)
        //取字串
        val name = intent.getStringExtra("NAME")

        //顯示在log並查錯功能
        Log.d(TAG, "onCreate: $level $name")
    }
    fun save(view: View){
        //日後可從Binding取得資料
        val nickname = binging.edNickname.text.toString()

        //將輸入資料儲存與顯示在畫面
        //edit() -> 編輯器
        //putString() -> 放資料
        //commit() -> 在這一行就把資料寫入
        //apply() -> 系統有時間時才資料寫入
        getSharedPreferences("guess", MODE_PRIVATE)
            .edit()
            .putString("nickname", nickname)
            .apply()


        //資料放到SetResult
        //RESULT_OK -> 狀態是OK
        //intent.putExtra("NICK", nickname) -> 回傳的資料
        setResult(RESULT_OK,intent.putExtra("NICK", nickname))

        //返回前一個Activity
        finish()
    }
}