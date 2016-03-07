package com.github.tkqubo.colorHash

case class ColorHash(
  lightness: Seq[Double] = ColorHash.defaultParam,
  saturation: Seq[Double] = ColorHash.defaultParam,
  hash: String => Long = ColorHash.defaultHash
) {
  def this(lightness: Double, saturation: Double) = this(Seq(lightness), Seq(saturation))
  def this(lightness: Double, saturation: Double, hash: String => Long) = this(Seq(lightness), Seq(saturation), hash)

  def hsl(text: String): Hsl = {
    var hashedValue: Long = hash(text)
    val H: Long = hashedValue % 359
    hashedValue = hashedValue / 360
    val S: Double = saturation((hashedValue % saturation.length).toInt)
    hashedValue = hashedValue / saturation.length
    val L: Double = lightness((hashedValue % lightness.length).toInt)
    Hsl(hue = H, lightness = L, saturation = S)
  }

  def rgb(text: String): Rgb = hsl(text).toRgb
  
  def hex(text: String): String = rgb(text).toHex
}

object ColorHash {
  val defaultParam: Seq[Double] = Seq(0.35, 0.5, 0.65)
  def defaultHash: String => Long = BkdrHash.bkdrHash

  def fromLightness(lightness: Double, hash: String => Long): ColorHash = ColorHash(lightness = Seq(lightness), hash = hash)
  def fromLightness(lightness: Double): ColorHash = ColorHash(lightness = Seq(lightness))
  def fromSaturation(saturation: Double): ColorHash = ColorHash(saturation = Seq(saturation))
  def fromSaturation(saturation: Double, hash: String => Long): ColorHash = ColorHash(saturation = Seq(saturation), hash = hash)
}
