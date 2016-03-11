# Color Hash

Scala version of [color-hash](https://github.com/zenozeng/color-hash)

## Usage

```scala
import com.github.tkqubo.colorHash._

val colorHash = ColorHash()

colorHash.hsl("foo")
// Hsl(94,0.35,0.65)

colorHash.rgb("foo")
// Rgb(162,197,135)


colorHash.hex("foo")
// "#A2C587"

val customizedColorHash = ColorHash(
  saturation = Seq(0.5),
  lightness = Seq(0.35, 0.5, 0.65),
  hash = _.length
)
```
