package com.example.languageleraningapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ChapterActivity : AppCompatActivity() {

    lateinit var chapters: List<AlphabetData.Chapter>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        val type = intent.getStringExtra("type") ?: "hiragana"

        chapters = if (type == "hiragana")
            AlphabetData.hiraganaChapters
        else
            AlphabetData.katakanaChapters

        val category = type.lowercase().replaceFirstChar { it.uppercase() }

        val titleView = findViewById<TextView>(R.id.titlealphabet)
        

        titleView.text = category

        val container = findViewById<LinearLayout>(R.id.chapterContainer)

        chapters.forEachIndexed { index, chapter ->
            val btn = Button(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    val marginInDp = (8 * resources.displayMetrics.density).toInt()
                    setMargins(marginInDp, marginInDp, marginInDp, marginInDp)
                }

                text = chapter.title
                setBackgroundResource(R.drawable.category)
                setTextColor(android.graphics.Color.WHITE)

                setOnClickListener {
                    val intent = Intent(this@ChapterActivity, LessonActivity::class.java)
                    intent.putExtra("chapterIndex", index)
                    intent.putExtra("type", type)
                    startActivity(intent)
                }
            }

            container.addView(btn)
        }
    }
}
