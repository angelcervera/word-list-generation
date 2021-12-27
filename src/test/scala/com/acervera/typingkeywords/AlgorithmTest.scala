package com.acervera.typingkeywords
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.wordspec.AnyWordSpecLike

class AlgorithmTest extends AnyWordSpecLike with Matchers {
  val coleman_line = "arstg"
  "Algorithm" should {
    "generate proper index per word" in {
      val words = Table(
        ("word", "line", "expected index"),
        (coleman_line, coleman_line, 0.0),
        (
          coleman_line.reverse,
          coleman_line,
          0.0
        ),
        ("rst", coleman_line, 0.0),
        ("ars", coleman_line, 0.0),
        ("arsqwf", coleman_line, 0.5),
        ("qwfpb", coleman_line, 1)
      )

      forAll(words) { (word, line, expectedIndex) =>
        Algorithm.indexWord(word, line) shouldBe expectedIndex
      }
    }

    "generate indexes for all words" in {
      val indexed = Algorithm
        .indexWords(
          Seq(
            "arstg",
            "zxcdv",
            "arszxc"
          ).iterator,
          Seq("arstg", "`zxcdv")
        )

      indexed.toSeq shouldBe Seq(
        Indexed("arstg", Seq(0.0, 1.0)),
        Indexed("zxcdv", Seq(1.0, 0.0)),
        Indexed("arszxc", Seq(0.5, 0.5))
      )
    }

    "generate indexes for all words in a file" in {
      val indexed = Algorithm
        .indexFileOfWords(
          "src/test/resources/words_test.txt",
          Seq("arstg", "`zxcdv")
        )

      indexed.toSeq shouldBe Seq(
        Indexed("arstg", Seq(0.0, 1.0)),
        Indexed("zxcdv", Seq(1.0, 0.0)),
        Indexed("arszxc", Seq(0.5, 0.5))
      )
    }
  }

}
