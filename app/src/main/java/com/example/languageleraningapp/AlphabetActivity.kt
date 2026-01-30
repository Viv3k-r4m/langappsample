package com.example.languageleraningapp

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlphabetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        findViewById<Button>(R.id.btnHiragana).setOnClickListener {
            val i = Intent(this, ChapterActivity::class.java)
            i.putExtra("type", "hiragana")
            startActivity(i)
        }

        findViewById<Button>(R.id.btnKatakana).setOnClickListener {
            val i = Intent(this, ChapterActivity::class.java)
            i.putExtra("type", "katakana")
            startActivity(i)
        }
    }
}
