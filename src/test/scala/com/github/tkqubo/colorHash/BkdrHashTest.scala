package com.github.tkqubo.colorHash

import org.specs2.mutable.Specification


/**
  * Test class for [[BkdrHash]]
  * {{{
  * sbt "test-only com.github.tkqubo.colorHash.BkdrHashTest"
  * }}}
  */
// scalastyle:off magic.number
class BkdrHashTest extends Specification {
  "BkdrHash$Test" should {
    "bkdrHash" in {
      BkdrHash.bkdrHash("") === 120 // just a result of node's color-hash
    }
    "bkdrHash" in {
      BkdrHash.bkdrHash("yo") === 2091142 // just a result of node's color-hash
    }
    "bkdrHash" in {
      BkdrHash.bkdrHash("foo") === 231224814 // just a result of node's color-hash
    }
  }
}
