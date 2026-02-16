package com.example.languageleraningapp

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class StatusWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val notificationHelper = NotificationHelper(applicationContext)
        notificationHelper.showNotification(
            "Hourly Status",
            "Keep learning! Your Japanese progress is looking great.",
            1001
        )
        return Result.success()
    }
}
