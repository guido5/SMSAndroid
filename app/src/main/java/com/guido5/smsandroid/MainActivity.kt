package com.guido5.smsandroid

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.guido5.smssenderandroid.SMSHandler


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val message = "nuevo mensaje"
        val numero = "5555555555"
        if(SMSHandler.getSmsHandler(this).smsSender.sendText(numero, message)) {
            Toast.makeText(this, "Se envio el mensaje", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == SMSHandler.SENDSMSPERMISSIONREQUEST) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val message = "nuevo mensaje"
                val numero = "5555555555"
                if(SMSHandler.getSmsHandler(this).smsSender.sendText(numero, message)) {
                    Toast.makeText(this, "Se envio el mensaje", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}