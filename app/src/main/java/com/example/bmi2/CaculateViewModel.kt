package com.example.bmi2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CaculateViewModel : ViewModel() {
    val status = MutableLiveData<CaculateStatus>()

    //當類別物件GuessViewModel被生成的時候，出現在MainActivity2
    // 建構子被建構完了，還要多執行什麼指令，可以放在init內
    init{
        status.value = CaculateStatus.INIT
    }

    fun caculate (weight : Float, height : Float):CaculateStatus {
        val BMI = (weight / (height * height)).toFloat()
        return if (BMI < 18.5) CaculateStatus.TooLight
        else if (BMI >= 35) CaculateStatus.ServereObesity
        else if (BMI >= 30) CaculateStatus.ModeratelyObese
        else if (BMI >= 27) CaculateStatus.MildObesity
        else if (BMI >= 24) CaculateStatus.TooHeavy
        else CaculateStatus.Standard
    }

    fun reset() {
        status.value = CaculateStatus.INIT
    }
}

enum class CaculateStatus {
    INIT,TooLight,Standard,TooHeavy,MildObesity,ModeratelyObese,ServereObesity
}