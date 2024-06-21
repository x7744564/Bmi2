package com.example.bmi2.student

fun main() {
    //匿名類別-> 去繼承一個介面
    val reports= listOf<Report>(
        FinanceReport(),
        HealthReport(),
        object: Report {
            override fun load() {
                println("Ex Report")
            }

            override fun print(title: String) {
                println("Printing")
            }
        }
    )
    for(report in reports) {
        report.load()
        report.print("Test")
    }
}