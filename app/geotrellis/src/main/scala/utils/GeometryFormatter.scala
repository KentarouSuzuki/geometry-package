package utils

import geotrellis.vector.Geometry
import geotrellis.vector.io.wkb.WKB

object WKBFormatter extends WKBFormatterInterface[Geometry, Array[Byte]] {
  override def read(value: Array[Byte]): Geometry = WKB.read(value)
  override def write(geom: Geometry): Array[Byte] = WKB.write(geom, 3857)
}

object GeometryFormatter extends GeometryFormatterFactory[Geometry, Array[Byte]]{
  override val wkbFormatter: WKBFormatterInterface[Geometry, Array[Byte]] = WKBFormatter
}
