package com.github.tkqubo.colorHash

case class Rgb(
  red: Int,
  green: Int,
  blue: Int
) {
  def toHex: String = s"#${toSeq.map("%02X" format _).mkString("")}"
  private def toSeq: Seq[Int] = Seq(red, green, blue)
}
