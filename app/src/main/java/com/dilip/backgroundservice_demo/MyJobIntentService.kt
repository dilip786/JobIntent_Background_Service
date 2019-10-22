package com.dilip.backgroundservice_demo

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService


class MyJobIntentService : JobIntentService() {


    override fun onHandleWork(intent: Intent) {
        Log.e("MyApp", "onHandleWork()")

        for (i in 1..20) {
            Thread.sleep(1000)
            Log.e("MyApp", "i =$i")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MyApp", "onDestroy()")
    }

    companion object {

        private const val JOB_ID = 1

        fun enqueueWork(context: Context, intent: Intent) {
            Log.e("MyApp", "enqueueWork()")
            enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }
    }
}