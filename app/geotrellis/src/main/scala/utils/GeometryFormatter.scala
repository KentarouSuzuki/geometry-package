package utils

import geotrellis.vector.Geometry
import geotrellis.vector.io.wkb.WKB
import org.locationtech.jts.io.WKBWriter

object WKBFormatter extends WKBFormatterInterface[Geometry, String] {
  override def read(value: String): Geometry = WKB.read(value)
  override def write(geom: Geometry): String= {
    WKBWriter.toHex(WKB.write(geom, 3857))
  }
}

object GeometryFormatter extends GeometryFormatterFactory[Geometry, String]{
  override val wkbFormatter: WKBFormatterInterface[Geometry, String] = WKBFormatter
}
