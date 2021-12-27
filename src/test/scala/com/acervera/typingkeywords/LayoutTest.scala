package com.acervera.typingkeywords

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class LayoutTest extends AnyWordSpecLike with Matchers {

  "Layout" should {
    "read layout from CSV file" in {
      Layout.readLayoutFromFile(
        "src/test/resources/layout_test.txt"
      ) shouldBe (
        Seq(
          "123456!@£$%^",
          "`~zxcdv",
          "7890=-&*()+_",
          "jluy;'\":"
        )
      )
    }
  }
}
