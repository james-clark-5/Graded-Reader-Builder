package WriteSummaryPages

import java.io.PrintWriter
import java.util.ArrayList


fun writeVocabSection(outputStoryWriter: PrintWriter, inputVocabFilename: String, vocabComponentArray: ArrayList<ArrayList<String>>){
    // add page title, remove indenting
    outputStoryWriter.println("\\clearpage")
    outputStoryWriter.println("\\setlength{\\parindent}{0ex}")
    outputStoryWriter.println("\\centerline{Vocabulary}")

    // print all vocab entries to page
    vocabComponentArray.forEachIndexed { index, currentComponentArray ->
        outputStoryWriter.println("" + (index+1) + ". " + vocabComponentArray[index][0] + " " + "\\pinyin{" + vocabComponentArray[index][1]+ "}: " + vocabComponentArray[index][2] + "\\\\")
    }
}

// TODO fun writeTeXGrammarSection
// TODO fun writeTeXQuestionsSection