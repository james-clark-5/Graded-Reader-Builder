package LanguageUtils

fun prefixLaTeXLanguageMarker (languageUsed: String) : String{
    var languageMarker = ""
    when (languageUsed) {
        "mandarin" -> languageMarker = "(\\pinyin{"
        "arabic" -> languageMarker = "(\\arabicfont{"
        else -> System.out.println("Unrecognised language:$languageUsed")
    }
    return languageMarker
}