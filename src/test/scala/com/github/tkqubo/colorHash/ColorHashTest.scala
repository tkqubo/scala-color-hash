package com.github.tkqubo.colorHash

import org.specs2.matcher.Matcher
import org.specs2.mutable.Specification

/**
  * Test class for [[ColorHashTest]]
  * {{{
  * sbt "test-only com.github.tkqubo.colorHash.ColorHashTest"
  * }}}
  */
// scalastyle:off magic.number
class ColorHashTest extends Specification {
  "ColorHashTest" should {
    "hsl" in {
      ColorHash().hsl("yo") === Hsl(326, 0.35d, 0.5d)
      ColorHash().hsl("more complex text") === Hsl(194, 0.5, 0.65)
    }

    "hex" in {
      ColorHash().hex("yo") === "#AC5385"
      ColorHash().hex("more complex text") === "#79BED2"
      ColorHash().hex("this") === "#783A52"
      ColorHash().hex("that") === "#C587B2"
      ColorHash().hex("漢字") === "#A7D279"
    }

    "rgb" in {
      ColorHash().rgb("yo") === Rgb(172, 83, 133)
      ColorHash().rgb("more complex text") === Rgb(121, 190, 210)
    }

    "apply" should {
      "pass with default parameters" in {
        val instance = ColorHash()
        instance.lightness === ColorHash.defaultParam
        instance.saturation === ColorHash.defaultParam
        instance.hash must beSameMethod(ColorHash.defaultHash)
      }

      "pass with custom parameters" in {
        val instance = ColorHash(Seq(0.1, 0.2), Seq(0.0, 0.5), _.length)
        instance.lightness === Seq(0.0, 0.5)
        instance.saturation === Seq(0.1, 0.2)
        instance.hash("1234567890") === 10L
      }
    }
  }

  private def beSameMethod(expected: String => Long): Matcher[(String => Long)] = { actual: (String => Long) =>
    (1 to 10).forall { _ =>
      val text: String = scala.util.Random.alphanumeric.take(10).mkString
      expected(text) aka s"hash for $text" must_=== actual(text)
    }
  }
}
