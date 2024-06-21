package com.example.bmi2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.bmi2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewModel: CaculateViewModel

    //類別的簡單名稱
    val  TAG = MainActivity2::class.java.simpleName

    //全域變數, lateinit -> 晚點一定會產生物件的連結
    private lateinit var binding :ActivityMainBinding

    val bmi =BmiCaculate()

    //一開始會自動生成onCreat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        //val binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        //this -> MainActivity2
//        viewModel = ViewModelProvider(this).get(CaculateViewModel::class.java)
//
//        //viewModel需要頃聽(當資料有變就做處理)
//        viewModel.status.observe(this) { status->
//            val message = when(status) {
//                CaculateStatus.TooLight -> getString(R.string.toolight)
//                CaculateStatus.Standard -> getString(R.string.standard)
//                CaculateStatus.TooHeavy -> getString(R.string.standard)
//                CaculateStatus.MildObesity -> getString(R.string.mildobesity)
//                CaculateStatus.ModeratelyObese -> getString(R.string.moderatelyobese)
//                CaculateStatus.ServereObesity -> getString(R.string.servereobesity)
//                else -> getString(R.string.standard)
//            }
//            //不是初始化都需要跳出對話框
//            if (status != CaculateStatus.INIT) {
//                AlertDialog.Builder(this)
//                    .setTitle(getString(R.string.info))
//                    .setMessage(message)
//                    .setPositiveButton(getString(R.string.ok), null)
//                    .setNegativeButton("Replay") { dialog, which ->
//                        //Log.d("MainActivity2", "Replay")
//                        Log.d(TAG, "Replay")
//                        viewModel.reset()
//                    }
//                    .show()
//            }
//        }
    }

    fun guess(view: View) {
        //傳入資料
        //val weight = binding.weight.text.toString().toFloat()
        //val height = binding.height.text.toString().toFloat()
        //viewModel.caculate( weight,height)
        //正常從資源取得字串的寫法
        //resources.getString(R.string.smaller)

        if(!binding.weight.text.toString().equals("") && !binding.height.text.toString().equals("")) {
            //取得物件的資料
            //透過 binding 取得layout上的資料
            val weight = binding.weight.text.toString().toFloat()
            val height = binding.height.text.toString().toFloat()

            val message = when(bmi.caculate(weight,height)) {
                BmiCaculate.Status.TooLight -> getString(R.string.toolight)
                BmiCaculate.Status.Standard -> getString(R.string.standard)
                BmiCaculate.Status.TooHeavy -> getString(R.string.tooheavy)
                BmiCaculate.Status.MildObesity -> getString(R.string.mildobesity)
                BmiCaculate.Status.ModeratelyObese -> getString(R.string.moderatelyobese)
                BmiCaculate.Status.ServereObesity -> getString(R.string.servereobesity)
                else -> ""
            }

            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok),null)
                .show()
        }
    }

}



