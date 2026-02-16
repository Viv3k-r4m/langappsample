package com.example.languageleraningapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BirthdayReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val name = intent.getStringExtra("FRIEND_NAME") ?: "Friend"
        val notificationHelper = NotificationHelper(context)
        notificationHelper.showNotification(
            "Birthday Reminder!",
            "It's $name's birthday! Don't forget to wish them.",
            2001
        )
    }
}
