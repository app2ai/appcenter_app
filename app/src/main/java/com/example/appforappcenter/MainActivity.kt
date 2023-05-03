package com.example.appforappcenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    lateinit var workManager: WorkManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workManager = WorkManager.getInstance(applicationContext)

        // val orderWorker =
        //     OneTimeWorkRequestBuilder<NotifWorker>()
        //         .setInputData(Data.EMPTY)
        //         .build()
        //
        // workManager.beginUniqueWork(
        //     Constants.NEW_ORDER_WORKER_ID,
        //     ExistingWorkPolicy.REPLACE,
        //     orderWorker
        // ).enqueue()
    }
}