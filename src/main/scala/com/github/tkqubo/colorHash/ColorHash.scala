package com.github.tkqubo.colorHash

case class ColorHash(
  lightness: Seq[Double] = ColorHash.defaultParam,
  saturation: Seq[Double] = ColorHash.defaultParam,
  hash: String => String = ColorHash.defaultHash
) {
  def this(lightness: Double, saturation: Double) = this(Seq(lightness), Seq(saturation))
}

object ColorHash {
  val defaultParam: Seq[Double] = Seq(0.35, 0.5, 0.65)
  private val defaultHash: String => String = _

  def fromLightness(lightness: Double): ColorHash =
    ColorHash(lightness = Seq(lightness))
  def fromSaturation(saturation: Double): ColorHash =
    ColorHash(saturation = Seq(saturation))
}
