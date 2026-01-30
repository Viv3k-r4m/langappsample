package com.example.languageleraningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class VocabCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocab_category)

        val container = findViewById<LinearLayout>(R.id.vocabCategoryContainer)

        VocabularyData.categories.forEachIndexed { index, category ->
            val btn = Button(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    val marginInDp = (8 * resources.displayMetrics.density).toInt()
                    setMargins(marginInDp, marginInDp, marginInDp, marginInDp)
                }

                text = category.name
                setBackgroundResource(R.drawable.category)
                setTextColor(android.graphics.Color.WHITE)

                setOnClickListener {
                    val intent = Intent(this@VocabCategoryActivity, VocabularyActivity::class.java)
                    intent.putExtra("categoryIndex", index)
                    startActivity(intent)
                }
            }

            container.addView(btn)
        }
    }
}
