package com.dilip.backgroundservice_demo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Broadcast receiver
    class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            if (intent!!.action == Intent.ACTION_BOOT_COMPLETED) {
                var serviceIntent = Intent(context!!, MyJobIntentService::class.java)
                MyJobIntentService.enqueueWork(context, intent = intent)
            }
        }
    }

    private var myReceiver = MyReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "JobIntent Service"
    }

    fun startService(view: View) {
        var intent = Intent(this, MyJobIntentService::class.java)
        MyJobIntentService.enqueueWork(this, intent = intent)
    }
}
