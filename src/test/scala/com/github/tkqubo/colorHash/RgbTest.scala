package com.github.tkqubo.colorHash

import org.specs2.mutable.Specification

/**
  * Test class for [[RgbTest]]
  * {{{
  * sbt "test-only com.github.tkqubo.colorHash.RgbTest"
  * }}}
  */
// scalastyle:off magic.number
class RgbTest extends Specification {
  "RgbTest" should {
    "toHex" in {
      Rgb(123, 234, 255).toHex === "#7BEAFF"
    }
    "toHex" in {
      Rgb(  0,   1,   2).toHex === "#000102"
    }
    "toHex" in {
      Rgb( 11,  22,  33).toHex === "#0B1621"
    }
  }
}
