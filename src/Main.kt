import java.io.File
import java.io.PrintWriter
import java.util.*

/**
 * Created by james-clark-5 (Idios) on 12/06/17.
 * Graded-Reader-Builder
 * Description: a program to take simple text input and a vocabulary list to produce a graded reader book.
 */

// todo add table of contents to template, so code can be used to "fill it out"
//
//\lfoot{
//    x. 对她说 (\pinyin{dui4ta1shuo1}) said to her\\
//}
// and rfoot similarly

// todo: add support for figures
// add figures to tex (if line.contains(".png"))
//\begin{figure}[ht!]
//\centering
//\includegraphics[width=90mm]{exampleFigure.png}
//%	\caption{A simple caption \label{overflow}}
//\end{figure}


fun main(args: Array<String>) {
    val inputStoryFilename: String = "res/inputStory"
    val inputVocabFilename: String = "res/inputVocab"
    val inputHeaderFilename: String = "res/inputHeader"
    val outputStoryFilename: String = "res/outputStory.tex"
    val outputStoryWriter = PrintWriter(outputStoryFilename, "UTF-8") // create writer for output
    writeTexHeader(outputStoryWriter, inputHeaderFilename)
    writeTexStory(outputStoryWriter, inputStoryFilename)
    // addVocabFooters()

    outputStoryWriter.println("\\end{document}") // end the TeX document
    outputStoryWriter.close()

}

fun writeTexHeader(outputStoryWriter: PrintWriter, inputHeaderFilename: String){
    val inputHeaderFile: File = File(inputHeaderFilename) // get file ready
    val scan: Scanner = Scanner(inputHeaderFile)

    while(scan.hasNextLine()) {
        val line: String = scan.nextLine() // read all lines
        outputStoryWriter.println(line)  // write all header lines to output file
    }
    scan.close()
}

fun writeTexStory(outputStoryWriter: PrintWriter, inputStoryFilename: String){
    val inputHeaderFile: File = File(inputStoryFilename) // get file ready
    val scan: Scanner = Scanner(inputHeaderFile)

    while(scan.hasNextLine()) {
        val line: String = scan.nextLine() // read all lines
        if (line.contains("chapter)")) {   // if a line is has chapter info, do this
            var chapterString: String = line.substring(7, line.length)  //    substring of line -"chapter"
            outputStoryWriter.println("\\setstretch{1.5}")
            outputStoryWriter.println("{\\centering \\LARGE")
            outputStoryWriter.println("{Chapter N}\\\\") // TODO get chapter number
            outputStoryWriter.println("{\\uline{"+ chapterString + "}}\\\\}")
        }
        else {     // else (for now) assume we have ordinary text

            outputStoryWriter.println(line)
        // todo: create a new page if a certain number of characters has been written by using \clearpage
        }
    }
    scan.close()
}

fun addVocabFooters(){
    // split the InputVocabFile by lines (->array list) and find first part (by space delimiting) of given array entry
    // find the first instance of a given word from the vocab list in the output story
    // for that page, add a footer with the full information of that array entry

}

fun addVocabSuperscripts(){
    // for each entry in the vocab list, go through the outputStoryFile and add superscripts with that entry's index+1
}

