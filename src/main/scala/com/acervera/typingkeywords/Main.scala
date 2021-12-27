package com.acervera.typingkeywords
import com.acervera.typingkeywords.Generator.generateTrainingFiles

object Main extends App {
  val layout = Layout.readLayoutFromFile(args(0))
  generateTrainingFiles(args(1), layout, args(2))
}
