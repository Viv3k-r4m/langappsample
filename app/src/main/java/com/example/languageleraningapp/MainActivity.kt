package com.example.languageleraningapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAlphabet).setOnClickListener {
            startActivity(Intent(this, AlphabetActivity::class.java))
        }

        findViewById<Button>(R.id.btnVocab).setOnClickListener {
            startActivity(Intent(this, VocabCategoryActivity::class.java))
        }
    }
}
