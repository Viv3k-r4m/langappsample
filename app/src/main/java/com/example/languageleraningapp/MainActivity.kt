package com.example.languageleraningapp

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.*
import java.util.concurrent.TimeUnit
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermissions()
        setupHourlyNotifications()

        findViewById<Button>(R.id.btnAlphabet).setOnClickListener {
            startActivity(Intent(this, AlphabetActivity::class.java))
        }

        findViewById<Button>(R.id.btnVocab).setOnClickListener {
            startActivity(Intent(this, VocabCategoryActivity::class.java))
        }

        // b. Use Alert Dialog to properly close your application
        findViewById<Button>(R.id.btnExit).setOnClickListener {
            showExitDialog()
        }

        // c. Use Progress Dialog/Progress Ring for suitable case
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        findViewById<Button>(R.id.btnShowProgress).setOnClickListener {
            simulateLoading(progressBar)
        }

        // d. Use Date and Time Picker for Birthday Dates
        findViewById<Button>(R.id.btnBirthday).setOnClickListener {
            showDateTimePicker()
        }
    }

    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 101)
            }
        }
    }

    // a. Send Status notification every hour
    private fun setupHourlyNotifications() {
        val workRequest = PeriodicWorkRequestBuilder<StatusWorker>(1, TimeUnit.HOURS)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setTitle("Exit Application")
            .setMessage("Are you sure you want to close the app?")
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun simulateLoading(progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
        // Simulate a 2-second delay
        progressBar.postDelayed({
            progressBar.visibility = View.GONE
            Toast.makeText(this, "Progress Complete!", Toast.LENGTH_SHORT).show()
        }, 2000)
    }

    private fun showDateTimePicker() {
        val calendar = Calendar.getInstance()
        
        DatePickerDialog(this, { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)

            TimePickerDialog(this, { _, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                calendar.set(Calendar.SECOND, 0)

                scheduleBirthdayNotification(calendar.timeInMillis)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun scheduleBirthdayNotification(timeInMillis: Long) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, BirthdayReceiver::class.java).apply {
            putExtra("FRIEND_NAME", "A Friend")
        }
        
        val pendingIntent = PendingIntent.getBroadcast(
            this, 0, intent, 
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
            }
        } else {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
        }

        Toast.makeText(this, "Birthday reminder set!", Toast.LENGTH_SHORT).show()
    }
}
