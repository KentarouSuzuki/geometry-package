package utils

import utils.Enums.GeometryFileTypes._

trait GeometryFormatterInterface[Geometry, A] {
  def read(value: A): Geometry
  def write(geom: Geometry): A
}

trait WKBFormatterInterface[Geometry] extends GeometryFormatterInterface[Geometry, String]

trait GeometryFormatterFactory[Geometry]{
  val wkbFormatter: WKBFormatterInterface[Geometry]

  def apply(fileType: FileType) = fileType match {
    case WKB => wkbFormatter
  }
}