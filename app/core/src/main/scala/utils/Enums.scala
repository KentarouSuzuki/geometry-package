package utils

sealed trait EnumType{
  val value: String
  override def toString: String = value
}

object Enums {
  object GeometryTypes {
    sealed class GeometryType(v: String) extends EnumType{
      override val value: String = v
    }

    final object Point extends GeometryType("point")
    final object LineString extends GeometryType("lineString")
    final object Polygon extends GeometryType("polygion")
    final object MultiPoint extends GeometryType("multiPoint")
    final object MultiLineString extends GeometryType("multiLineString")
    final object MultiPolygon extends GeometryType("multiPolygon")
  }

  object GeometryFileTypes {
    sealed class FileType(v: String) extends EnumType{
      override val value: String = v
    }

    final object WKB extends FileType("wkt")
  }
}
