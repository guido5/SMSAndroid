package com.guido5.smssenderandroid

import androidx.appcompat.app.AppCompatActivity

class SMSHandler private constructor(activity: AppCompatActivity) {

    val smsSender: SMSSenderUseCase

    init {
        smsSender = SMSSenderImp(activity)
    }

    companion object {

        val SENDSMSPERMISSIONREQUEST = 1
        fun getSmsHandler(activity: AppCompatActivity) : SMSHandler {
            return SMSHandler(activity)
        }
    }
}