package com.example.languageleraningapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
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
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val wordContainer = findViewById<LinearLayout>(R.id.wordContainer)
        val lessonCompletedContainer = findViewById<LinearLayout>(R.id.lessonCompletedContainer)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        txtCategoryTitle.text = currentCategory.name
        progressBar.max = currentCategory.words.size

        fun updateUI() {
            if (currentIndex < currentCategory.words.size) {
                val word = currentCategory.words[currentIndex]
                txtJapanese.text = word.japanese
                txtRomaji.text = word.romaji
                txtEnglish.text = word.english
                progressBar.progress = currentIndex + 1
                wordContainer.visibility = View.VISIBLE
                lessonCompletedContainer.visibility = View.GONE
            } else {
                wordContainer.visibility = View.GONE
                lessonCompletedContainer.visibility = View.VISIBLE
            }
        }

        updateUI()

        btnNext.setOnClickListener {
            currentIndex++
            updateUI()
        }

        btnRestart.setOnClickListener {
            currentIndex = 0
            updateUI()
        }
    }
}
