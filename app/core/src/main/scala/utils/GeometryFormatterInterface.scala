package utils

import utils.Enums.GeometryFileTypes._

trait GeometryFormatterInterface[Geometry, A] {
  def read(value: A): Geometry
  def write(geom: Geometry): A
}

trait WKBFormatterInterface[Geometry, A] extends GeometryFormatterInterface[Geometry, A]

trait GeometryFormatterFactory[Geometry, A]{
  val wkbFormatter: WKBFormatterInterface[Geometry, A]

  def apply(fileType: FileType): WKBFormatterInterface[Geometry, A] = fileType match {
    case WKB => wkbFormatter
  }
}