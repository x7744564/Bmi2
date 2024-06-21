package com.example.bmi2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//利用runBlocking來執行main的所有方法
//main() 主執行續會逐一執行每個方法
fun main() = runBlocking {
//    Thread(){
//        //把這個工作放在另外一個執行緒執行
//        doSomething()
//    }.start()

    launch {
        //協程
        doSomethingElse()
    }


    println("Hello ${Thread.currentThread().name}") //印出執行序名稱
}

suspend fun doSomethingElse(){
    delay(1000L) //一秒後執行
    println("Do something... ${Thread.currentThread().name}") //印出執行緒名稱
}

fun doSomething() {

    println("Do something... ${Thread.currentThread().name}") //印出執行緒名稱
}