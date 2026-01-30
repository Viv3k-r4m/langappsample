package com.example.languageleraningapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LessonActivity : AppCompatActivity() {

    private lateinit var chapter: AlphabetData.Chapter
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val chapterIndex = intent.getIntExtra("chapterIndex", 0)
        val type = intent.getStringExtra("type") ?: "hiragana"

        val formattedType = type.lowercase().replaceFirstChar { it.uppercase() }
        findViewById<TextView>(R.id.titlefor).text = formattedType

        chapter = if (type == "hiragana")
            AlphabetData.hiraganaChapters[chapterIndex]
        else
            AlphabetData.katakanaChapters[chapterIndex]

        val txtJP = findViewById<TextView>(R.id.txtJP)
        val txtRomaji = findViewById<TextView>(R.id.txtRomaji)
        val txtSound = findViewById<TextView>(R.id.txtSound)
        val btnNext = findViewById<Button>(R.id.btnNext)

        fun show() {
            val letter = chapter.letters[index]
            txtJP.text = letter.jp
            txtRomaji.text = "Romaji: " + letter.romaji
            txtSound.text = "Sound: " + letter.sound
        }

        show()

        btnNext.setOnClickListener {
            index = (index + 1) % chapter.letters.size
            show()
        }
    }
}
