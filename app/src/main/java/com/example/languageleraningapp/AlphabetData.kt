package com.example.languageleraningapp

object AlphabetData {

    data class Letter(val jp: String, val romaji: String, val sound: String)
    data class Chapter(val title: String, val letters: List<Letter>)

    // Complete Hiragana
    val hiraganaChapters: List<Chapter> = listOf(
        Chapter("Vowels", listOf(
            Letter("あ","a","ah"), Letter("い","i","ee"), Letter("う","u","oo"),
            Letter("え","e","eh"), Letter("お","o","oh")
        )),
        Chapter("K", listOf(
            Letter("か","ka","kah"), Letter("き","ki","kee"), Letter("く","ku","koo"),
            Letter("け","ke","keh"), Letter("こ","ko","koh")
        )),
        Chapter("S", listOf(
            Letter("さ","sa","sah"), Letter("し","shi","shee"), Letter("す","su","soo"),
            Letter("せ","se","seh"), Letter("そ","so","soh")
        )),
        Chapter("T", listOf(
            Letter("た","ta","tah"), Letter("ち","chi","chee"), Letter("つ","tsu","tsoo"),
            Letter("て","te","teh"), Letter("と","to","toh")
        )),
        Chapter("N", listOf(
            Letter("な","na","nah"), Letter("に","ni","nee"), Letter("ぬ","nu","noo"),
            Letter("ね","ne","neh"), Letter("の","no","noh")
        )),
        Chapter("H", listOf(
            Letter("は","ha","hah"), Letter("ひ","hi","hee"), Letter("ふ","fu","foo"),
            Letter("へ","he","heh"), Letter("ほ","ho","hoh")
        )),
        Chapter("M", listOf(
            Letter("ま","ma","mah"), Letter("み","mi","mee"), Letter("む","mu","moo"),
            Letter("め","me","meh"), Letter("も","mo","moh")
        )),
        Chapter("Y", listOf(
            Letter("や","ya","yah"), Letter("ゆ","yu","yoo"), Letter("よ","yo","yoh")
        )),
        Chapter("R", listOf(
            Letter("ら","ra","rah"), Letter("り","ri","ree"), Letter("る","ru","roo"),
            Letter("れ","re","reh"), Letter("ろ","ro","roh")
        )),
        Chapter("W", listOf(
            Letter("わ","wa","wah"), Letter("を","wo","woh")
        )),
        Chapter("N", listOf(
            Letter("ん","n","n")
        ))
    )

    // Complete Katakana
    val katakanaChapters: List<Chapter> = listOf(
        Chapter("Vowels", listOf(
            Letter("ア","a","ah"), Letter("イ","i","ee"), Letter("ウ","u","oo"),
            Letter("エ","e","eh"), Letter("オ","o","oh")
        )),
        Chapter("K", listOf(
            Letter("カ","ka","kah"), Letter("キ","ki","kee"), Letter("ク","ku","koo"),
            Letter("ケ","ke","keh"), Letter("コ","ko","koh")
        )),
        Chapter("S", listOf(
            Letter("サ","sa","sah"), Letter("シ","shi","shee"), Letter("ス","su","soo"),
            Letter("セ","se","seh"), Letter("ソ","so","soh")
        )),
        Chapter("T", listOf(
            Letter("タ","ta","tah"), Letter("チ","chi","chee"), Letter("ツ","tsu","tsoo"),
            Letter("テ","te","teh"), Letter("ト","to","toh")
        )),
        Chapter("N", listOf(
            Letter("ナ","na","nah"), Letter("ニ","ni","nee"), Letter("ヌ","nu","noo"),
            Letter("ネ","ne","neh"), Letter("ノ","no","noh")
        )),
        Chapter("H", listOf(
            Letter("ハ","ha","hah"), Letter("ヒ","hi","hee"), Letter("フ","fu","foo"),
            Letter("ヘ","he","heh"), Letter("ホ","ho","hoh")
        )),
        Chapter("M", listOf(
            Letter("マ","ma","mah"), Letter("ミ","mi","mee"), Letter("ム","mu","moo"),
            Letter("メ","me","meh"), Letter("モ","mo","moh")
        )),
        Chapter("Y", listOf(
            Letter("ヤ","ya","yah"), Letter("ユ","yu","yoo"), Letter("ヨ","yo","yoh")
        )),
        Chapter("R", listOf(
            Letter("ラ","ra","rah"), Letter("リ","ri","ree"), Letter("ル","ru","roo"),
            Letter("レ","re","reh"), Letter("ロ","ro","roh")
        )),
        Chapter("W", listOf(
            Letter("ワ","wa","wah"), Letter("ヲ","wo","woh")
        )),
        Chapter("N", listOf(
            Letter("ン","n","n")
        ))
    )

}
