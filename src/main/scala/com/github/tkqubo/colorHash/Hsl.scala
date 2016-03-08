package com.github.tkqubo.colorHash

case class Hsl(hue: Long, saturation: Double, lightness: Double) {
  def toRgb: Rgb = {
    val normalizedHue: Double = hue.toDouble / 360.0d
    val q: Double = if (lightness < 0.5d) lightness * (1.0d + saturation) else lightness + saturation - lightness * saturation
    val p: Double = 2.0d * lightness - q
    Rgb(
      toRgbColor(normalizedHue + (1.0d / 3.0d), p, q),
      toRgbColor(normalizedHue                , p, q),
      toRgbColor(normalizedHue - (1.0d / 3.0d), p, q)
    )
  }

  private def toRgbColor(color: Double, p: Double, q: Double): Int = {
    val normalizedColor: Double = if (color < 0.0d) {
      color + 1.0d
    } else if (color > 1.0d) {
      color - 1.0d
    } else {
      color
    }

    val calculatedColor: Double = if (normalizedColor < 1.0d / 6.0d) {
      p + (q - p) * 6.0d * normalizedColor
    } else if (normalizedColor < 0.5d) {
      q
    } else if (normalizedColor < 2.0d / 3.0d) {
      p + (q - p) * 6.0d * (2.0d / 3.0d - normalizedColor)
    } else {
      p
    }

    Math.round(calculatedColor * 255).toInt
  }
}
