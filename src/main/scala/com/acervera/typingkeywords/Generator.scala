package com.acervera.typingkeywords
import better.files._
import com.acervera.typingkeywords.Algorithm.indexFileOfWords
import com.acervera.typingkeywords.Layout.Layout

object Generator {
  def generateTrainingFiles(
      filePath: String,
      layout: Layout,
      outputFolder: String
  ): Unit = {
    File(outputFolder).createDirectories()
    for {
      level1 <- outputFolder / "level1.txt" printWriter (true)
      level2 <- outputFolder / "level2.txt" printWriter (true)
      level3 <- outputFolder / "level3.txt" printWriter (true)
    } {
      indexFileOfWords(filePath, layout)
        .foreach(idx => {
          println(idx)
          if (idx.indexes(2) == 0) {
            level1.println(idx.word)
            level2.println(idx.word)
            level3.println(idx.word)
          } else if (idx.indexes(1) == 1) {
            level2.println(idx.word)
            level3.println(idx.word)
          } else {
            level3.println(idx.word)
          }
        })
    }

  }
}
