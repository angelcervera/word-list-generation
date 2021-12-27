package com.acervera.typingkeywords
import better.files._
import com.acervera.typingkeywords.Layout.Layout
case class Indexed(word: String, indexes: Seq[Double])

object Algorithm {

  def indexFileOfWords(filePath: String, layout: Layout): Iterator[Indexed] =
    indexWords(File(filePath).lineIterator, layout)

  def indexWords(words: Iterator[String], layout: Layout): Iterator[Indexed] =
    words.map(word =>
      Indexed(word, layout.map(keyboardLine => indexWord(word, keyboardLine)))
    )

  def indexWord(word: String, line: String): Double =
    word.foldLeft(0.0)((acc, c) =>
      acc + { if (!line.contains(c)) 1 else 0 }
    ) / word.length
}
