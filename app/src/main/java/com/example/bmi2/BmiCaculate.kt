//Homework02
package com.example.bmi2

class BmiCaculate {
    enum class Status {
        INIT,TooLight,Standard,TooHeavy,MildObesity,ModeratelyObese,ServereObesity
    }

    var status = Status.INIT

    fun caculate (weight: Float, height:Float) : Status {
        //reference　BMI URL: https://depart.femh.org.tw/dietary/3OPD/BMI.htm
        //過輕: BMI ＜ 18.5
        //正常範圍: 18.5≦BMI＜24
        //過重：24≦BMI＜27
        //輕度肥胖：27≦BMI＜30
        //中度肥胖：30≦BMI＜35
        //重度肥胖：BMI≧35

        val BMI = weight/square(height)
        return if (BMI < 18.5) Status.TooLight
        else if (BMI >= 35) Status.ServereObesity
        else if (BMI >= 30) Status.ModeratelyObese
        else if (BMI >= 27) Status.MildObesity
        else if (BMI >= 24) Status.TooHeavy
        else if (BMI >= 18.5) Status.Standard
        else Status.INIT
    }

    private fun square(height: Float): Float {
        val square = height * height
        return square
    }

    fun main(){
        //Execute class method
        val bmi = BmiCaculate()
        val weight = 0.toFloat()
        val height = 0.toFloat()
        val result = bmi.caculate(weight,height)
    }

}