package com.acervera.typingkeywords
import better.files.File

object Layout {

  // Layout is a sequence of key lines, each key defined as a char.
  type Layout = Seq[String]

  def readLayoutFromFile(filePath: String): Layout =
    File(filePath).lines.toSeq

}
