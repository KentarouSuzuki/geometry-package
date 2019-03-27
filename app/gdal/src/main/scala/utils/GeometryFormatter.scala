package utils

import org.gdal.ogr.Geometry
import org.gdal.ogr.ogr.CreateGeometryFromWkb

object WKBFormatter extends WKBFormatterInterface[Geometry, Array[Byte]] {
  override def read(value: Array[Byte]): Geometry = CreateGeometryFromWkb(value)
  override def write(geom: Geometry): Array[Byte] = geom.ExportToWkb()
}

object GeometryFormatter extends GeometryFormatterFactory[Geometry, Array[Byte]] {
  override val wkbFormatter: WKBFormatterInterface[Geometry, Array[Byte]] = WKBFormatter
}