package com.example.languageleraningapp

object VocabularyData {
    data class Word(val japanese: String, val romaji: String, val english: String)
    data class Category(val name: String, val words: List<Word>)

    val categories = listOf(
        Category("Basic Words", listOf(
            Word("こんにちは", "Konnichiwa", "Hello"),
            Word("ありがとう", "Arigatou", "Thank you"),
            Word("すみません", "Sumimasen", "Excuse me / Sorry"),
            Word("はい", "Hai", "Yes"),
            Word("いいえ", "Iie", "No"),
            Word("おやすみなさい", "Oyasumi nasai", "Good night"),
            Word("さようなら", "Sayounara", "Goodbye")
        )),
        Category("Animals", listOf(
            Word("いぬ", "Inu", "Dog"),
            Word("ねこ", "Neko", "Cat"),
            Word("うさぎ", "Usagi", "Rabbit"),
            Word("とり", "Tori", "Bird"),
            Word("さかな", "Sakana", "Fish"),
            Word("うま", "Uma", "Horse"),
            Word("くま", "Kuma", "Bear")
        )),
        Category("Fruits", listOf(
            Word("りんご", "Ringo", "Apple"),
            Word("ばなな", "Banana", "Banana"),
            Word("いちご", "Ichigo", "Strawberry"),
            Word("ぶどう", "Budou", "Grape"),
            Word("みかん", "Mikan", "Orange"),
            Word("すいか", "Suika", "Watermelon")
        )),
        Category("Vegetables", listOf(
            Word("やさい", "Yasai", "Vegetable"),
            Word("とまと", "Tomato", "Tomato"),
            Word("にんじん", "Ninjin", "Carrot"),
            Word("たまねぎ", "Tamanegi", "Onion"),
            Word("じゃがいも", "Jagaimo", "Potato"),
            Word("きゅうり", "Kyuuri", "Cucumber")
        ))
    )
}
