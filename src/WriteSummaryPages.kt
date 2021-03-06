package WriteSummaryPages

import java.io.PrintWriter
import java.util.ArrayList


fun writeVocabSection(outputStoryWriter: PrintWriter, inputVocabFilename: String, vocabComponentArray: ArrayList<ArrayList<String>>){
    outputStoryWriter.println("\\clearpage")
    outputStoryWriter.println("\\setlength{\\parindent}{0ex}") // remove indenting
    outputStoryWriter.println("\\centerline{Vocabulary}")     // add page title

    // TODO use "\\pinyin" or other for tone marking; i.e. language-dependency.
    // print all vocab entries to page
    if (vocabComponentArray[1].size == 2){
        vocabComponentArray.forEachIndexed { index, currentComponentArray ->
            outputStoryWriter.println("" + (index+1) + ". " + vocabComponentArray[index][0] + " " + vocabComponentArray[index][1] + "\\\\")
        }
    }
    else if (vocabComponentArray[1].size == 3) {
        vocabComponentArray.forEachIndexed { index, currentComponentArray ->
            outputStoryWriter.println("" + (index + 1) + ". " + vocabComponentArray[index][0] + " " + "\\pinyin{" + vocabComponentArray[index][1] + "}: " + vocabComponentArray[index][2] + "\\\\")
        }
    }
}

// TODO fun writeTeXGrammarSection
// TODO fun writeTeXQuestionsSection