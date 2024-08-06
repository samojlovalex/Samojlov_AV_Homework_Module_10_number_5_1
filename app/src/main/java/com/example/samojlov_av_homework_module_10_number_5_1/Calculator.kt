package com.example.samojlov_av_homework_module_10_number_5_1

class Calculator(val first: String, val  second: String) {
    private val firs_=first
    private val second_ = second
    fun operation (a: Double, b: Double, op: (Double, Double) -> Double): Double{
        val result = op (a,b)
        return result
    }
    val plus = operation(firs_.toDouble(),second_.toDouble(), fun (a: Double, b: Double) = a + b)
    val minus = operation(firs_.toDouble(),second_.toDouble(), fun (a: Double, b: Double) = a - b)
    val multiplication = operation(firs_.toDouble(),second_.toDouble(), fun (a: Double, b: Double) = a * b)
    val divisionBT = operation(firs_.toDouble(),second_.toDouble(), fun (a: Double, b: Double) = a / b)

}