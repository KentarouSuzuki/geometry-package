package utils

import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.io.{WKBReader, WKBWriter}

object WKBFormatter extends WKBFormatterInterface[Geometry, String] {
  override def read(value: String): Geometry = {
    val arrayBytes = WKBReader.hexToBytes(value)
    new WKBReader().read(arrayBytes)
  }
  override def write(geom: Geometry): String= {
    val arrayBytes = new WKBWriter(2, true).write(geom)
    WKBWriter.toHex(arrayBytes)
  }
}

object GeometryFormatter extends GeometryFormatterFactory[Geometry, String]{
  override val wkbFormatter: WKBFormatterInterface[Geometry, String] = WKBFormatter
}