package com.guido5.smssenderandroid

import android.Manifest
import android.content.pm.PackageManager
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SMSSenderImp(private val activity: AppCompatActivity) : SMSSenderUseCase {

    private fun checkPermission() : Boolean {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.SEND_SMS)
            == PackageManager.PERMISSION_GRANTED)
            return true
        return false
    }
    override fun sendText(phoneNumber: String, message: String): Boolean {
        if (checkPermission()) {
            val smsManager: SmsManager = activity.getSystemService(SmsManager::class.java)
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            return true
        } else {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.SEND_SMS), SMSHandler.SENDSMSPERMISSIONREQUEST)
        }
        return false
    }
}