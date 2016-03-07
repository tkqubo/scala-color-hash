package com.github.tkqubo.colorHash

object BkdrHash {
  val seed = 131
  val seed2 = 137
  val maxSafeLong: Long = 65745979961613L // parseInt(9007199254740991 / seed2) in JavaScript

  def bkdrHash(str: String): Long = {
    var hash: Long = 0
    s"${str}x".toCharArray.foreach { (char: Char) =>
      if (hash > maxSafeLong) {
        hash = hash / seed2
      }
      hash = hash * seed + char
    }
    hash
  }
}
