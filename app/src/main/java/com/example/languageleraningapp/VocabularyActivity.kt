package com.example.languageleraningapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VocabularyActivity : AppCompatActivity() {

    private var currentIndex = 0
    private lateinit var currentCategory: VocabularyData.Category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        val categoryIndex = intent.getIntExtra("categoryIndex", 0)
        currentCategory = VocabularyData.categories[categoryIndex]

        val txtCategoryTitle = findViewById<TextView>(R.id.txtCategoryTitle)
        val txtJapanese = findViewById<TextView>(R.id.txtJapanese)
        val txtRomaji = findViewById<TextView>(R.id.txtRomaji)
        val txtEnglish = findViewById<TextView>(R.id.txtEnglish)
        val btnNext = findViewById<Button>(R.id.btnNextWord)

        txtCategoryTitle.text = currentCategory.name

        fun updateUI() {
            val word = currentCategory.words[currentIndex]
            txtJapanese.text = word.japanese
            txtRomaji.text = word.romaji
            txtEnglish.text = word.english
        }

        updateUI()

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % currentCategory.words.size
            updateUI()
        }
    }
}
