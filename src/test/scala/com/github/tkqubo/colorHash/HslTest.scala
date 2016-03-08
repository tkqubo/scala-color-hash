package com.github.tkqubo.colorHash

import org.specs2.mutable.Specification

/**
  * Test class for [[HslTest]]
  * {{{
  * sbt "test-only com.github.tkqubo.colorHash.HslTest"
  * }}}
  */
// scalastyle:off magic.number
class HslTest extends Specification {
  "HslTest" should {
    "toRgb" in {
      Hsl(  0, 0.47, 0.85).toRgb must beApproximatelyEqual(Rgb(236, 198, 198))
    }
    "toRgb" in {
      Hsl(248, 0.07, 0.67).toRgb must beApproximatelyEqual(Rgb(166, 164, 176))
    }
  }

  private def beApproximatelyEqual(expected: Rgb) = { actual: Rgb =>
    actual.red aka "red" must beBetween(expected.red - 1, expected.red + 1)
    actual.green aka "green" must beBetween(expected.green - 1, expected.green + 1)
    actual.blue aka "blue" must beBetween(expected.blue - 1, expected.blue + 1)
  }
}
