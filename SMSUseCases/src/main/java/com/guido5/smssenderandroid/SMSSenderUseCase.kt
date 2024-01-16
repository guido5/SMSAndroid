package com.guido5.smssenderandroid

interface SMSSenderUseCase {
    fun sendText(phoneNumber: String, message: String) : Boolean

}